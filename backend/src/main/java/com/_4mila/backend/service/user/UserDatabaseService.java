package com._4mila.backend.service.user;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.JwtUtility;
import com._4mila.backend.model.user.User;
import com._4mila.backend.model.user.User_;
import com._4mila.backend.model.user.permission.PermissionFunction;
import com._4mila.backend.model.user.permission.PermissionFunctionEnum;
import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.DateUtility;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.exception.BackendValidationException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import spark.Request;

public class UserDatabaseService extends AbstractCrudDatabaseService<User, Long> {

	private static final Logger logger = LoggerFactory.getLogger(UserDatabaseService.class);
	private static final String PASSWORD_DUMMY = "**********";

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	protected void orderBy(Root<User> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(User_.username)));
	}

	@Override
	public void createPathListEntry(User entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getUsername());
	}

	@Override
	protected void beforeCreate(User entity) {
		super.beforeCreate(entity);
		entity.setEncryptedPassword(encryptPassword(entity.getPassword()));
		validate(entity);
	}

	@Override
	protected void beforeUpdate(User entity) {
		super.beforeUpdate(entity);
		validate(entity);
	}

	@Override
	protected void afterRead(User entity) {
		super.afterRead(entity);
		if (entity != null) {
			entity.setPassword(PASSWORD_DUMMY);
			entity.setRepeatPassword(PASSWORD_DUMMY);
		}
	}

	private void validate(User entity) {
		if (entity.getPassword() != null && entity.getPassword().equals(PASSWORD_DUMMY) && entity.getRepeatPassword() != null && entity.getRepeatPassword().equals(PASSWORD_DUMMY)) {
			User original = read(entity.getKey());
			entity.setEncryptedPassword(original.getEncryptedPassword());
		} else if (entity.getPassword().equals(entity.getRepeatPassword())) {
			entity.setEncryptedPassword(encryptPassword(entity.getPassword()));
		} else {
			throw new BackendValidationException("PasswordsDoNotMatchError");
		}

		if (!DateUtility.checkDateOrder(entity.getEvtCreationDate(), entity.getEvtClosingDate())) {
			throw new BackendValidationException("DateOrderError");
		}

		entity.setEvtClosingDate(DateUtility.truncateToDay(entity.getEvtClosingDate()));
		entity.setEvtCreationDate(DateUtility.truncateToDay(entity.getEvtCreationDate()));
	}

	private byte[] encryptPassword(String password) {
		if (password == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			return md.digest();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException("Failed encrypting password", e);
		}
	}

	private boolean isActiveUser(User user) {
		return DateUtility.checkDateOrder(new Date(), user.getEvtClosingDate()) &&
				DateUtility.checkDateOrder(user.getEvtCreationDate(), new Date());
	}

	public boolean validateCredentials(String email, String password) {
		List<User> users = this.list(new UsernameFilter(email));
		if (users.size() == 1) {
			User user = users.get(0);
			if (!isActiveUser(user)) {
				return false;
			}
			logger.info("Login with user " + email + " and language de");
			return Arrays.equals(user.getEncryptedPassword(), encryptPassword(password));
		}
		return false;
	}

	public User getCurrentUser(Request request) {
		Jws<Claims> jwt = JwtUtility.getJsonWebToken(request);
		if (jwt == null || jwt.getBody() == null) {
			throw new BackendValidationException("NotLoggedInErrorMessage");
		}
		String userId = jwt.getBody().getSubject();
		List<User> users = list(new UsernameFilter(userId));
		if (users.size() != 1) {
			throw new RuntimeException("No current user found");
		}
		User user = users.get(0);
		if (!isActiveUser(user)) {
			throw new BackendValidationException("NoPermissionError");
		}
		return user;
	}
	
	private Collection<String> getPermissions(User user) {
		Set<String> result = new HashSet<>();
		for (PermissionRole role : user.getPermissionRoles()) {
			for (PermissionFunction function : role.getPermissionFunctions()) {
				result.add(function.getKey().toLowerCase());
			}
		}
		return result;
	}
	
	public boolean checkPermissionFunction(User user, String permissionFunctionKey) {
		if (permissionFunctionKey != null) {
			permissionFunctionKey = permissionFunctionKey.toLowerCase();
		}
		return getPermissions(user).contains(permissionFunctionKey);
	}

	public void checkPermissionFunction(Request req, PermissionFunctionEnum... permissionFunctions) {
		if (permissionFunctions == null || permissionFunctions.length == 0) {
			return;
		}
		for (PermissionFunctionEnum permissionFunction : permissionFunctions) {
			boolean check = checkPermissionFunction(getCurrentUser(req), permissionFunction.name());
			if (check) {
				return;
			}
		}
		throw new BackendValidationException("NoPermissionError");
	}

	public class UsernameFilter extends AbstractCrudDatabaseService<User, Long>.AbstractListFilter {
		private String email;

		public UsernameFilter(String email) {
			super();
			this.email = email;
		}

		@Override
		public void appendFilter(CriteriaQuery<User> criteriaQuery, Root<User> root) {
			if (email != null) {
				email = email.toLowerCase();
			}
			CriteriaBuilder cb = getCriteriaBuilder();
			addPredicate(criteriaQuery, cb.equal(cb.lower(root.get(User_.username)), email));
		}
	}

}

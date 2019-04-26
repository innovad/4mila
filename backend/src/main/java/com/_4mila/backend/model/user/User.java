package com._4mila.backend.model.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.server.json.ExcludeFromJson;

@Entity
@Table(name = "UserAccount")
public class User extends AbstractEntity implements Comparable<User> {

	private String username;

	@Transient
	private String password;

	@Transient
	private String repeatPassword;

	@ExcludeFromJson
	private byte[] encryptedPassword;

	private Date evtCreationDate;

	private Date evtClosingDate;

	@ManyToMany
	@JoinTable(name = "User_PermissionRoles", inverseJoinColumns = @JoinColumn(name = "permissionRole_key"))
	private Set<PermissionRole> permissionRoles = new HashSet<>();
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public byte[] getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(byte[] encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Date getEvtClosingDate() {
		return evtClosingDate;
	}

	public void setEvtClosingDate(Date evtClosingDate) {
		this.evtClosingDate = evtClosingDate;
	}

	public Date getEvtCreationDate() {
		return evtCreationDate;
	}

	public void setEvtCreationDate(Date evtCreationDate) {
		this.evtCreationDate = evtCreationDate;
	}

	public Set<PermissionRole> getPermissionRoles() {
		return permissionRoles;
	}
	
	@Override
	public int compareTo(User o) {
		return this.username.compareTo(o.username);
	}

}

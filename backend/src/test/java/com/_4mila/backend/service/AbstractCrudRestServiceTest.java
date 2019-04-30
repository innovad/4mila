package com._4mila.backend.service;

import static org.junit.Assert.assertEquals;
import static spark.Spark.awaitInitialization;
import static spark.Spark.awaitStop;
import static spark.Spark.port;
import static spark.Spark.stop;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.server.json.JsonHelper;
import com.google.common.io.CharStreams;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public abstract class AbstractCrudRestServiceTest<E extends AbstractEntity, KEYTYPE> extends AbstractDatabaseUnitTest {

	private AbstractCrudRestService<E, KEYTYPE, ?> service;

	private int port = 4568;

	protected abstract Class<?> getService();

	protected abstract Class<E> getEntityClass();

	protected void beforeCreate(E entity) {
	}

	@SuppressWarnings("unchecked")
	@Before
	public void before() throws Exception {
		port = 4568;
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			port = Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		port(port);

		service = (AbstractCrudRestService<E, KEYTYPE, ?>) getInjector().getInstance(getService());
		service.init();
		awaitInitialization();
	}

	@After
	public void after() {
		stop();
		awaitStop();
	}

	@Test
	public void testList() throws Exception {
		E entity = getInjector().getInstance(getEntityClass());
		Object svcObject = service.getCrudDatabaseService();
		@SuppressWarnings("unchecked")
		AbstractCrudDatabaseService<E, KEYTYPE> svc = (AbstractCrudDatabaseService<E, KEYTYPE>) svcObject;
		beforeCreate(entity);
		svc.create(entity);

		String serviceName = Character.toLowerCase(getEntityClass().getSimpleName().charAt(0)) + getEntityClass().getSimpleName().substring(1);
		String jsonResult = testGet(serviceName);

		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals(1, result.size());

		svc.delete(entity);
	}

	protected String testGet(String serviceName) throws IOException, ClientProtocolException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet("http://localhost:" + port + "/services/" + serviceName);
		HttpResponse getResponse = httpClient.execute(getRequest);
		assertEquals(200, getResponse.getStatusLine().getStatusCode());
		HttpEntity getResponseEntity = getResponse.getEntity();
		Reader reader = new InputStreamReader(getResponseEntity.getContent());

		String jsonResult = CharStreams.toString(reader);
		return jsonResult;
	}

	protected String testPost(String serviceName, String resource) throws IOException, ClientProtocolException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost("http://localhost:" + port + "/services/" + serviceName);

		if (resource != null) {
			File file = new File(getClass().getClassLoader().getResource(resource).getFile());

			FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("upload", fileBody);
			HttpEntity entity = builder.build();
			postRequest.setEntity(entity);
		}

		HttpResponse postResponse = httpClient.execute(postRequest);
		assertEquals(200, postResponse.getStatusLine().getStatusCode());
		HttpEntity getResponseEntity = postResponse.getEntity();
		Reader reader = new InputStreamReader(getResponseEntity.getContent());

		String jsonResult = CharStreams.toString(reader);
		return jsonResult;
	}

	protected List<PathListEntry<Long>> parsePathListJson(String jsonResult) {
		TypeToken<ArrayList<PathListEntry<Long>>> token = new TypeToken<ArrayList<PathListEntry<Long>>>() {
		};
		List<PathListEntry<Long>> result = null;
		try {
			result = getInjector().getInstance(JsonHelper.class).getGson().fromJson(jsonResult, token.getType());
		} catch (JsonSyntaxException e) {
			throw new RuntimeException("Cannot parse " + jsonResult, e);
		}
		return result;
	}

}

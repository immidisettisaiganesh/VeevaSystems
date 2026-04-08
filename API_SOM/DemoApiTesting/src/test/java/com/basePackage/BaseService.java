package com.basePackage;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification res;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	// Base service
	public BaseService() {
		res = given().baseUri(BASE_URI);
	}

	protected void setToken(String token) {
		res.header("Authorization", "Bearer " + token);
	}

	public Response postService(Object payLoad, String endpoint) {
		return res.contentType(ContentType.JSON).body(payLoad).when().post(endpoint);
	}

	public Response getService(String url) {
		return res.get(url);
	}
}

package com.api.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.service.AuthService;

import io.restassured.response.Response;
import junit.framework.Assert;

@Listeners(com.api.listeners.TestListener.class)
public class LoginApiTest {
	@Test
	public void testLogin() {

		// passing the data from pojos to service and taking the request from the
		// service class and validating that response then by deserialization using
		// jackson
		// that response is handled using the response pojo ;

		AuthService auth = new AuthService();

		Response res = auth.login(new LoginRequest("saiganeshimmidisetti@gmail.com", "S@ig@nesh@9999"));
		Assert.assertEquals(200, res.getStatusCode());

		System.out.println(res.asPrettyString());

		LoginResponse loginResponse = res.as(LoginResponse.class);

		System.out.println(loginResponse.getToken());

	}
}

package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.ResetPasswordRequest;
import com.api.service.AuthService;

import io.restassured.response.Response;

public class ResetPasswordTest {

	@Test
	public void restPasswordTest() {

		AuthService auth=new AuthService();
		ResetPasswordRequest payload=new ResetPasswordRequest.Builder()
							.token("a0b6b690-a68d-4403-ba6a-6d91903ef91a")
							.newPassword("S@ig@nesh@9999")
							.confirmPassword("S@ig@nesh@9999")
							.build();
		
		Response resetPassRes=auth.restPassword(payload);
		System.out.println(resetPassRes.then().log().all());
		Assert.assertEquals(200, resetPassRes.getStatusCode());
	}
}

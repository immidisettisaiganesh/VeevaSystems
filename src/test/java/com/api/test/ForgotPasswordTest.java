package com.api.test;

import org.testng.annotations.Test;

import com.api.service.AuthService;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPass() {
		
		AuthService forgotAuth=new AuthService();
		Response forgotRes=forgotAuth.forgotPassword("saiganeshimmidisetti@gmail.com");
		System.out.println(forgotRes.then().log().all());
		Assert.assertEquals(200,forgotRes.getStatusCode());
		
	}
}	

package com.api.test;

import org.testng.annotations.Test;

import com.api.models.request.SignUpRequest;
import com.api.service.AuthService;

import io.restassured.response.Response;
import junit.framework.Assert;

public class AccountCreationTest {
	
	@Test(description = "Account creation tesing")
	public void createAccountTest() {
		
		AuthService auth=new AuthService();
		
		Response siupRes=auth.signUp(new SignUpRequest.Builder()
													  .email("snakskasttetetfwfwksfsfsa@gmail.com")
													  .username("saidfsgjgjfwwwrfggsfjj")
													  .password("Sjfsffsffhf@gmail.com")
													  .firstName("saffsfsfidw")
													  .lastName("gasffsfsfsfnir3f")
													  .mobileNumber("3223237272")
													  .build());
		// since response from signup is one line string noneed to create pojo for signupresponse class 	
		
		System.out.println(siupRes.then().log().all());
		Assert.assertEquals(200, siupRes.statusCode());
	}
	
}

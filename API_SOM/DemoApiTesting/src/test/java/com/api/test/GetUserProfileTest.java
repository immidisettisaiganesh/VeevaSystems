package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.service.AuthService;
import com.api.service.UserManagementService;

import io.restassured.response.Response;

public class GetUserProfileTest {
	
	@Test
	public void getProfile() {
		
		//User should login into system
		AuthService auth=new AuthService();
		Response  logRes=auth.login(new LoginRequest("saiganeshimmidisetti@gmail.com", "S@ig@nesh@9999"));
		Assert.assertEquals(200, logRes.getStatusCode());
		System.out.println("Logged into the system");
		String token=logRes.as(LoginResponse.class).getToken();
		
		System.out.println("-------------------------------------------------------------------------------------------");
		
		//Able to get profile of user after the sucessfull login
		UserManagementService ums=new UserManagementService();
		Response umsRes=ums.getUserProfile(token);
		UserProfileResponse profile=umsRes.as(UserProfileResponse.class);
		System.out.println(profile.toString());
		Assert.assertEquals(200, umsRes.getStatusCode());
		System.out.println(umsRes.asPrettyString());
	}
}

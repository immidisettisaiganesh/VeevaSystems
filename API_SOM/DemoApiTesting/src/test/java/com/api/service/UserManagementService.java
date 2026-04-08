package com.api.service;

import com.basePackage.BaseService;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{
	
	private static String BASE_PATH="/api/users/";
	
	public Response getUserProfile(String token) {
		setToken(token);
		return getService(BASE_PATH+"profile");
	}
}

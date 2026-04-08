package com.api.service;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.ResetPasswordRequest;
import com.api.models.request.SignUpRequest;
import com.basePackage.BaseService;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	private final static String BASE_URI="/api/auth/";
	
	
	// The data body from pojo to test to service and to base service 
	
	
	public Response login(LoginRequest payload) {
		return postService(payload, BASE_URI+"login");
	}
	
	public Response signUp(SignUpRequest payload) {
		return postService(payload, BASE_URI+"signup");
	}
	
	public Response restPassword(ResetPasswordRequest payload) {
		return postService(payload, BASE_URI+"reset-password");
	}
	
	public Response forgotPassword(String str) {
		
		//Since only one parameter no need to create pojo , it can be handled using hashMap
		HashMap<String, String>hm=new HashMap<String, String>();
		hm.put("email",str);
		return postService(hm, BASE_URI+"forgot-password");
	}
	
}

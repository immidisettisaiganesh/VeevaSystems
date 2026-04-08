package com.api.models.request;

public class LoginRequest {
	
	private String username;
	private String password;
	
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
	
	
}

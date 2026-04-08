package com.api.models.request;

public class ResetPasswordRequest {

	private String token;
	private String newPassword;
	private String confirmPassword;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public ResetPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResetPasswordRequest(String token, String newPassword, String confirmPassword) {
		super();
		this.token = token;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ResetPasswordRequest [token=" + token + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}

	public static class Builder {
		private String token;
		private String newPassword;
		private String confirmPassword;

		public Builder token(String token) {
			this.token = token;
			return this;
		}

		public Builder newPassword(String newPassword) {
			this.newPassword = newPassword;
			return this;
		}

		public Builder confirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}

		public ResetPasswordRequest build() {
			return new ResetPasswordRequest(token, newPassword, confirmPassword);
		}
	}
}

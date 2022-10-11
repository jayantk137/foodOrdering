package com.project.foodOrdering.dto;

public class UserResponse {

	private String token;
	private String message;
	private String role;

	private long user_id;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	

	public UserResponse(String token, String message, String role, long user_id) {
		super();
		this.token = token;
		this.message = message;
		this.role = role;
		this.user_id = user_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}

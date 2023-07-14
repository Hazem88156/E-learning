package com.elearning.dto;



public class AuthenticateDTO {
	
	public AuthenticateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthenticateDTO(String username, String token, boolean isauthnenticate, String message, UserDTO user) {
		super();
		this.username = username;
		this.token = token;
		this.isauthnenticate = isauthnenticate;
		this.message = message;
		this.user = user;
	}
	
	private static final long serialVersionUID = 8941630156100951973L;
	private String username;
	private String token;
	private boolean isauthnenticate;
	private String message;
	private UserDTO user;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isIsauthnenticate() {
		return isauthnenticate;
	}
	public void setIsauthnenticate(boolean isauthnenticate) {
		this.isauthnenticate = isauthnenticate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

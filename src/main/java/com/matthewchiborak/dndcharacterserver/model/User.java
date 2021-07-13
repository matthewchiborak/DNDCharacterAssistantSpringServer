package com.matthewchiborak.dndcharacterserver.model;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String token;
	
	public User() {
		super();
	}
	
	public User(String id, String username, String password, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	
	
	
	
}

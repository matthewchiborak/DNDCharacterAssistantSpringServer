package com.matthewchiborak.dndcharacterserver.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String authdata;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String password, String authdata) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authdata = authdata;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAuthdata() {
		return authdata;
	}

	public void setAuthdata(String authdata) {
		this.authdata = authdata;
	}
	
	
	
	
}

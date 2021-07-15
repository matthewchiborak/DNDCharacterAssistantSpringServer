package com.matthewchiborak.dndcharacterserver.model;

import org.springframework.data.annotation.Id;

public class Userdb {
	@Id
	private String id;
	private String username;
	private String password;
	private String salt;
	public Userdb() {
		super();
	}
	public Userdb(String id, String username, String password, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	
	
}

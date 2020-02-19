package com.shop.rest.base;

import java.io.Serializable;

public class BaseRestRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long receiTime;
	private String username;
	private String password;

	public void setReceiTime(long receiTime) {
		this.receiTime = receiTime;
	}

	public long getReceiTime() {
		return receiTime;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

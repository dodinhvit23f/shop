package com.shop.rest;

import java.io.Serializable;

public class RestHeader implements Serializable {
	private static final long serialVersionUID = 1380656044109525451L;

	private String language;
	private String secretKey;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

}

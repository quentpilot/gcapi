package com.gcapi.user;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CLUser implements IUser {

	protected String token = null;
	protected CloseableHttpClient httpClient = null;
	protected String key = null;
	protected String value = null;
	protected boolean status = false;
	
	public CLUser() {}
	
	public CLUser(String token, String key) {
		this.token = token;
		this.key = key;
		this.httpClient = HttpClients.createDefault();
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public CloseableHttpClient getHttp() {
		return this.httpClient;
	}

	public void setHttp(CloseableHttpClient http) {
		this.httpClient = http;
	}
}

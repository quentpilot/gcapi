package com.gcapi.user;

import org.apache.http.impl.client.CloseableHttpClient;

public interface IUser {
	
	public String getToken();
	public void setToken(String token);
	
	public CloseableHttpClient getHttp();
	public void setHttp(CloseableHttpClient http);
	
	public String getKey();
	public void setKey(String key);
	
	public String getValue();
	public void setValue(String value);
	
	public boolean getStatus();
	public void setStatus(boolean status);
}

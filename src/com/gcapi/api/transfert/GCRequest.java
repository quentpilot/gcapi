package com.gcapi.api.transfert;

import com.gcapi.api.IGcapi;
import com.gcapi.user.IUser;

public class GCRequest implements IGcapi {
	
	protected IUser user = null;
	protected String key = null;
	protected String value = null;
	
	public GCRequest() {
		
	}
	
	public IUser getUser() {
		return this.user;
	}

	public void setUser(IUser user) {
		this.user = user;
		
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

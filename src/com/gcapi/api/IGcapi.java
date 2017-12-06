package com.gcapi.api;

import com.gcapi.user.IUser;

public interface IGcapi {

	public IUser getUser();
	public void setUser(IUser user);
	public String getKey();
	public void setKey(String key);
	public String getValue();
	public void setValue(String value);
}

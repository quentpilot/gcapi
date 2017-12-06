package com.gcapi.api.transfert;

import org.json.JSONObject;

import com.gcapi.api.IGcapi;
import com.gcapi.user.IUser;

public class GCParser implements IGcapi {

	protected IUser user = null;
	protected String key = null;
	protected String value = null;
	protected JSONObject tab = null;
	
	public GCParser() {
	}
	
	public GCParser(String key) {
		this.key = key;
	}
	
	public GCParser(String key, JSONObject tab) {
		this.key = key;
		this.tab = tab;
		this.get();
	}
	
	public String get() {
		if (this.getKey() == null)
			return null;
		String slug = "USD" + this.getKey();
		String result = String.valueOf(this.getTab().getJSONObject("quotes").get(slug));
		this.setValue(result);
		return result;
	}
	
	public String get(String key) {
		String slug = "USD" + key;
		String result = String.valueOf(this.getTab().getJSONObject("quotes").get(slug));
		this.setValue(result);
		return result;
	}
	
	public static String get(String key, JSONObject tab) {
		String slug = "USD" + key;
		String result = String.valueOf(tab.getJSONObject("quotes").get(slug));
		return result;
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
	
	public JSONObject getTab() {
		return this.tab;
	}
	
	public void setTab(JSONObject tab) {
		this.tab = tab;
	}
}

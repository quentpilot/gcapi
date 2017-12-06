package com.gcapi.api;

import com.gcapi.api.transfert.GCParser;
import com.gcapi.api.transfert.GConnect;
import com.gcapi.user.IUser;

public class LCAPI implements IAPI, IGcapi {

	protected IUser user = null;
	protected String key = null;
	protected String value = "0.00";
	protected GConnect connection = null;
	protected GCParser finder = null;
	
	public LCAPI() {}
	
	public LCAPI(String key) {
		this.key = key;
		this.connection = new GConnect(key);
		this.finder = new GCParser(key);
	}
	
	public boolean run() {
		if (!this.connect())
			return false;
		if (!this.set())
			return false;
		if (!this.find())
			return false;
		return true;
	}

	public boolean connect() {
		return this.getConnection().connect();
	}

	public boolean set() {
		this.getFinder().setTab(this.getConnection().getCurrencies());
		this.setUser(this.getConnection().getUser());
		return true;
	}

	public boolean find() {
		this.setValue(this.getFinder().get());
		return true;
	}

	public String getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}

	public IUser getUser() {
		return this.user;
	}

	public void setUser(IUser user) {
		this.user = user;
		
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public GConnect getConnection() {
		return this.connection;
	}
	
	public void setConnection(GConnect connect) {
		this.connection = connect;
	}
	
	public GCParser getFinder() {
		return this.finder;
	}
	
	public void setFinder(GCParser finder) {
		this.finder = finder;
	}
}

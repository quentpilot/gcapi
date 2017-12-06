package com.gcapi;

import com.gcapi.api.LCAPI;

public final class Gcapi {

	protected String currency = null;
	protected String[] currencies = null;
	protected String value = "0.00";
	protected LCAPI api = null;
	
	public Gcapi() {
		System.out.println("Gcapi is looking for... nothing.");
	}
	
	public Gcapi(String currency) {
		this.currency = currency;
		this.api = new LCAPI(currency);
		this.api.run();
		this.value = this.getApi().getValue();
		System.out.println("Gcapi is looking for currency...");
	}
	
	public Gcapi(String[] currencies) {
		this.currencies = currencies;
		System.out.println("Gcapi is looking for currencies...");
	}

	public String getCurrency() {
		return currency;
	}
	
	public String[] getCurrencies() {
		return currencies;
	}

	public String getValue() {
		return value;
	}
	
	public LCAPI getApi() {
		return this.api;
	}
}

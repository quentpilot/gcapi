package com.gcapi.api.transfert;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.gcapi.api.IGcapi;
import com.gcapi.user.CLUser;
import com.gcapi.user.IUser;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class GConnect implements IGcapi {

	protected String url = null;
	protected String endpoint = null;
	protected String date = null;
	protected JSONObject currencies = null;
	protected IUser user = null;
	protected String key = null;
	protected String value = "0.00"; 
	
	
	public GConnect() {
		this.key = "USD";
		this.value = "1.00";
		this.user = this.getDefaultClient();
		this.url = "http://apilayer.net/api/";
		this.endpoint = "live";
	}
	
	public GConnect(String key) { 
		this.key = key;
		this.user = this.getDefaultClient();
		this.url = "http://apilayer.net/api/";
		this.endpoint = "live";
	}
	
	public GConnect(IUser user, String key) {
		this.user = user;
		this.key = key;
		this.url = "http://apilayer.net/api/";
		this.endpoint = "live";
	}
	
	public boolean connect() {
		if (this.getUser() == null)
			return false;
		HttpGet get = new HttpGet(this.getUrl() + this.getEndpoint() + "?access_key=" + this.getUser().getToken());
		try {
			CloseableHttpResponse 	response =  this.getUser().getHttp().execute(get);
            HttpEntity 				entity = response.getEntity();
            JSONObject 				exchangeRates = new JSONObject(EntityUtils.toString(entity));
            Date 					timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000)); 
            DateFormat 				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String 					formattedDate = dateFormat.format(timeStampDate);
            
            this.setCurrencies(exchangeRates);
            this.setDate(formattedDate);
			this.getUser().setStatus(true);
			return true;
		} catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	protected IUser getDefaultClient() {
		CLUser client = new CLUser("dcb58b9b5616ec547b25f205561cea6f", this.getKey());
		return client;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public JSONObject getCurrencies() {
		return currencies;
	}

	public void setCurrencies(JSONObject currencies) {
		this.currencies = currencies;
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

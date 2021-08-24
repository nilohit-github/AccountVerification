package com.mock.account.model;

import java.io.Serializable;

public class Company implements Serializable{
	
	private Long QuoteAmount;
	private String DUNSID;
	private String name;
	private String zip;
	
	
	public Long getQuoteAmount() {
		return QuoteAmount;
	}
	public void setQuoteAmount(Long quoteAmount) {
		QuoteAmount = quoteAmount;
	}
	public String getDUNSID() {
		return DUNSID;
	}
	public void setDUNSID(String dUNSID) {
		DUNSID = dUNSID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}

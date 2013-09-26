package com.presupuestar.model.user.profile;

import java.util.List;

public class FullProfile extends Profile {

	private static final long serialVersionUID = 1L;
	
	private String reason;
	private List<Address> addresses;
	private List<Phone> phones;
	private String webPage;

	public FullProfile() {
		super();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

}

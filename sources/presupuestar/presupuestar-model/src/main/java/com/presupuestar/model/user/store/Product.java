package com.presupuestar.model.user.store;

import com.presupuestar.model.DomainObject;

public class Product extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	private String description;
	private double price;

	public Product() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

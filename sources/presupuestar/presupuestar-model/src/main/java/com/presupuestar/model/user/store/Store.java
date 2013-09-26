package com.presupuestar.model.user.store;

import java.util.List;

import com.presupuestar.model.DomainObject;

public class Store extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<Product> products;

	public Store() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}

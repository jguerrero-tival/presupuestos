package com.presupuestar.model.budget;

import com.presupuestar.model.DomainObject;

public class Item extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private double price;
	private int quantity;

	public Item() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

package com.presupuestar.model.budget;

import java.util.List;

import com.presupuestar.model.DomainObject;

public class ProductsDetail extends DomainObject {

	private static final long serialVersionUID = 1L;

	private String description;
	private double amount;
	private List<Item> items;

	public ProductsDetail() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}

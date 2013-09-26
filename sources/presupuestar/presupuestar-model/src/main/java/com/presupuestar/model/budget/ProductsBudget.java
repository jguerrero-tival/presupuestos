package com.presupuestar.model.budget;

import java.util.List;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.Commerce;

public class ProductsBudget extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private double amount;
	private Commerce commerce;
	private List<ItemBudget> itemsBudget;

	public ProductsBudget() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Commerce getCommerce() {
		return commerce;
	}

	public void setCommerce(Commerce commerce) {
		this.commerce = commerce;
	}

	public List<ItemBudget> getItemsBudget() {
		return itemsBudget;
	}

	public void setItemsBudget(List<ItemBudget> itemsBudget) {
		this.itemsBudget = itemsBudget;
	}

}

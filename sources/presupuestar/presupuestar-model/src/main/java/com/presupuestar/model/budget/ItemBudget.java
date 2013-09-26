package com.presupuestar.model.budget;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.store.Product;

public class ItemBudget extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private double amount;
	private Item item;
	private Product product;
	
	public ItemBudget() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

package com.presupuestar.model.budget;

import com.presupuestar.model.DomainObject;

public class LaborDetail extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private String description;
	private double amount;
	
	public LaborDetail() {
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

}

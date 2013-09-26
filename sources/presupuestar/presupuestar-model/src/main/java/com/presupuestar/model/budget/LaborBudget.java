package com.presupuestar.model.budget;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.Proffesional;

public class LaborBudget extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private double amount;
	private Proffesional proffesional;
	private LaborDetail laborDetail;
	private ProductsDetail productsDetail;

	public LaborBudget() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Proffesional getProffesional() {
		return proffesional;
	}

	public void setProffesional(Proffesional proffesional) {
		this.proffesional = proffesional;
	}

	public LaborDetail getLaborDetail() {
		return laborDetail;
	}

	public void setLaborDetail(LaborDetail laborDetail) {
		this.laborDetail = laborDetail;
	}

	public ProductsDetail getProductsDetail() {
		return productsDetail;
	}

	public void setProductsDetail(ProductsDetail productsDetail) {
		this.productsDetail = productsDetail;
	}

}

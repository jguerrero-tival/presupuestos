package com.presupuestar.model.budget;

import com.presupuestar.model.DomainObject;
import com.presupuestar.model.user.Professional;

public class LaborBudget extends DomainObject {

	private static final long serialVersionUID = 1L;
	
	private double amount;
	private Professional professional;
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

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
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

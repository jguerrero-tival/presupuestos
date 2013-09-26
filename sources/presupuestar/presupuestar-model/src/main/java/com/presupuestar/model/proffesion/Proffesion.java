package com.presupuestar.model.proffesion;

import com.presupuestar.model.DomainObject;

public class Proffesion extends DomainObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private Category category;

	public Proffesion() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

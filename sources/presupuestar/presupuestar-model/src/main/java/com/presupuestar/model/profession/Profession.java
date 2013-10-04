package com.presupuestar.model.profession;

import com.presupuestar.model.DomainObject;

public class Profession extends DomainObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private Category category;

	public Profession() {
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

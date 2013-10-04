package com.presupuestar.model.profession;

import java.util.List;

import com.presupuestar.model.DomainObject;

public class Category extends DomainObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Profession> professions;

	public Category() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Profession> getProfessions() {
		return professions;
	}

	public void setProfessions(List<Profession> professions) {
		this.professions = professions;
	}

}

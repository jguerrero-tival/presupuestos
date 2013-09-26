package com.presupuestar.model.proffesion;

import java.util.List;

import com.presupuestar.model.DomainObject;

public class Category extends DomainObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Proffesion> proffesions;

	public Category() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Proffesion> getProffesions() {
		return proffesions;
	}

	public void setProffesions(List<Proffesion> proffesions) {
		this.proffesions = proffesions;
	}

}

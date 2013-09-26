package com.presupuestar.model;

import java.io.Serializable;

public abstract class DomainObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	public DomainObject() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

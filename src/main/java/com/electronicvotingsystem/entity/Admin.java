package com.electronicvotingsystem.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Admin extends User{

	@NotNull
	private String designation;

	public Admin() {
		super();
	}

	public Admin( @NotNull String designation, User user) {
		super();
		this.designation = designation;

	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "Admin [ designation=" + designation + " ]";
	}
}

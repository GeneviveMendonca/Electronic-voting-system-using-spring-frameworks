package com.electronicvotingsystem.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class AdminDTO extends UserDTO{

	@NotNull
	private String designation;

	public AdminDTO() {
		super();
	}

	public AdminDTO( @NotNull String designation, UserDTO userDTO) {
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

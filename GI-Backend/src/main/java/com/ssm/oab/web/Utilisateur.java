package com.ssm.oab.web;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Id
	@Column(name = "CODEALLIANCE")
	private String codeAlliance;

	public Utilisateur() {
	}

	public Utilisateur(String firstName, String lastName, String codeAlliance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.codeAlliance = codeAlliance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCodeAlliance() {
		return codeAlliance;
	}

	public void setCodeAlliance(String codeAlliance) {
		this.codeAlliance = codeAlliance;
	}
	

}

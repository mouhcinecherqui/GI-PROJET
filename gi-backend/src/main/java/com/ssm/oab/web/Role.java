package com.ssm.oab.web;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOMROLE")
	private String NOMrole;

	@Id
	@Column(name = "ROLE")
	private String role;

	public Role() {
	}

	public Role(String role, String NOMrole) {
		this.role = role;
		this.NOMrole  = NOMrole ;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNOMrole() {
		return NOMrole;
	}

	public void setNOMrole(String NOMrole) {
		this.NOMrole = NOMrole;
	}

}
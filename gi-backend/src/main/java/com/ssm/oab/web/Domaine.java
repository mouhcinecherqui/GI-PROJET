package com.ssm.oab.web;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Domaine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOMDOMAINE")
	private String NOMdomaine;

	@Id
	@Column(name = "DMN")
	private String dmn;

	public Domaine() {
	}

	public Domaine(String dmn, String NOMdomaine) {
		this.dmn = dmn;
		this.NOMdomaine  = NOMdomaine ;
	}

	public String getDmn() {
		return dmn;
	}

	public void setDmn(String dmn) {
		this.dmn = dmn;
	}

	public String getNOMdomaine() {
		return NOMdomaine;
	}

	public void setNOMdomaine(String NOMdomaine) {
		this.NOMdomaine = NOMdomaine;
	}

}
package com.ssm.oab.gi.dao.entity;

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
	@Column(name = "DESCRIPTIONDMN")
	private String descriptiondmn;
	@Id
	@Column(name = "DMN")
	private String dmn;

	public Domaine() {
	}

	public Domaine(String dmn, String NOMdomaine, String descriptiondmn) {
		this.dmn = dmn;
		this.NOMdomaine  = NOMdomaine ;
		this.descriptiondmn  = descriptiondmn ;
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

	public String getDescriptiondmn() {
		return descriptiondmn;
	}

	public void setDescriptiondmn(String descriptiondmn) {
		this.descriptiondmn = descriptiondmn;
	}

}
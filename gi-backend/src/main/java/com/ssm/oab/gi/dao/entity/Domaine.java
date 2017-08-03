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
	private String nomDomaine;
	@Column(name = "DESCRIPTIONDMN")
	private String descriptiondmn;
	@Id
	@Column(name = "DMN")
	private String dmn;

	public Domaine() {
	}

	public String getDmn() {
		return dmn;
	}

	public void setDmn(String dmn) {
		this.dmn = dmn;
	}

	public String getDescriptiondmn() {
		return descriptiondmn;
	}

	public void setDescriptiondmn(String descriptiondmn) {
		this.descriptiondmn = descriptiondmn;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

}
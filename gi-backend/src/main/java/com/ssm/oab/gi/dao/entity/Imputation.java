package com.ssm.oab.gi.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imputation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "Jour")
	private double jour;

	@Column(name = "CODEPROJET")
	private String codeProjet;

	@Column(name = "CODEALLIANCE")
	private String codeAlliance;
	
	@Column(name = "IDIMPUTATIONS")
	private int idImputations;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeProjet() {
		return codeProjet;
	}

	public void setCodeProjet(String codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getCodeAlliance() {
		return codeAlliance;
	}

	public void setCodeAlliance(String codeAlliance) {
		this.codeAlliance = codeAlliance;
	}

	public double getJour() {
		return jour;
	}

	public void setJour(double jour) {
		this.jour = jour;
	}

	public int getIdImputations() {
		return idImputations;
	}

	public void setIdImputations(int idImputations) {
		this.idImputations = idImputations;
	}

}

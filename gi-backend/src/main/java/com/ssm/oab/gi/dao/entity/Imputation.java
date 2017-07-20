package com.ssm.oab.gi.dao.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imputation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DATE")
	private Calendar date;

	@Column(name = "Jour")
	private float jour;

	@Column(name = "CODEPROJET")
	private String codeProjet;

	@Column(name = "CODEALLIANCE")
	private String codeAlliance;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
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

	public float getJour() {
		return jour;
	}

	public void setJour(float jour) {
		this.jour = jour;
	}
}

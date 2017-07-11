package com.test.test.web;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Projet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "DESCRIPTION_PROJET")
	private String descriptionprojet;
	
	@Column(name = "NOM_PROJET")
	private String nomprojet;

	@Column(name = "NOM_COMPLET")
	private String nomcomplet;

	@Id
	@Column(name = "CODE_PROJET")
	private String codeprojet;

	public Projet() {
	}

	public Projet(String codeprojet, String descriptionprojet, String nomprojet, String nomcomplet) {
		this.codeprojet = codeprojet;
		this.descriptionprojet = descriptionprojet;
		this.nomprojet = nomprojet;
		this.nomcomplet = nomcomplet;
	}

	public String getCodeprojet() {
		return codeprojet;
	}

	public void setCodeprojet(String codeprojet) {
		this.codeprojet = codeprojet;
	}

	public String getDescriptionprojet() {
		return descriptionprojet;
	}

	public void setDescriptionprojet(String descriptionprojet) {
		this.descriptionprojet = descriptionprojet;
	}

	public String getNomcomplet() {
		return nomcomplet;
	}

	public void setNomcomplet(String nomcomplet) {
		this.nomcomplet = nomcomplet;
	}
	
	public String getNomprojet() {
		return nomprojet;
	}

	public void setNomprojet(String nomprojet) {
		this.nomprojet = nomprojet;
	}




}
package com.ssm.oab.web;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Imputation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DATE")
	private GregorianCalendar date;

	@Column(name = "JOUR")
	private Float jour ;


	@Id
	@Column(name = "ID")
	private String id;


	public GregorianCalendar getDate() {
		return date;
	}


	public void setDate(GregorianCalendar date) {
		this.date = date;
	}


	public Float getJour() {
		return jour;
	}


	public void setJour(Float jour) {
		this.jour = jour;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	}

package com.ssm.oab.gi.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ImputationDTO {

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;

	private double jour;

	private Long id;

	private String codeProjet;

	private String codeAlliance;
	
	private int idImputations;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getJour() {
		return jour;
	}

	public void setJour(double jour) {
		this.jour = jour;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdImputations() {
		return idImputations;
	}

	public void setIdImputations(int idImputations) {
		this.idImputations = idImputations;
	}
}

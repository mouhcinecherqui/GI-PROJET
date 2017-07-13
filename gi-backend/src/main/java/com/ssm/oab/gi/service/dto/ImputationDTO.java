package com.ssm.oab.gi.service.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ImputationDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Calendar date;

	private Float jour;

	private Long id;

	private String codeProjet;

	private String codeAlliance;

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Float getJour() {
		return jour;
	}

	public void setJour(Float jour) {
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

}

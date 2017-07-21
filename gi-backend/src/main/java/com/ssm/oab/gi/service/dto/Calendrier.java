package com.ssm.oab.gi.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class Calendrier {

	private int annee;
	private String nomMois;
	private int numeroMois;

	private List<JourDuMois> joursDuMois;

	public List<JourDuMois> getJoursDuMois() {
		return joursDuMois;
	}

	public void setJoursDuMois(List<JourDuMois> joursDuMois) {
		this.joursDuMois = joursDuMois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getNomMois() {
		return nomMois;
	}

	public void setNomMois(String nomMois) {
		this.nomMois = nomMois;
	}

	public int getNumeroMois() {
		return numeroMois;
	}

	public void setNumeroMois(int numeroMois) {
		this.numeroMois = numeroMois;
	}

}

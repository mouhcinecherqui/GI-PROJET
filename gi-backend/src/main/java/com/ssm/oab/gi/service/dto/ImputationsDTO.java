package com.ssm.oab.gi.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssm.oab.gi.dao.entity.Projet;

public class ImputationsDTO {

	private int id;
	private Calendrier calendrier;
	private Projet projet;
	private List<ImputationDTO> listeImputation = new ArrayList<>();

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<ImputationDTO> getListeImputation() {
		return listeImputation;
	}

	public void setListeImputation(List<ImputationDTO> listeImputation) {
		this.listeImputation = listeImputation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

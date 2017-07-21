package com.ssm.oab.gi.service.dto;

import java.util.List;
import java.util.Map;

public class ImputationsDTO {

	private Calendrier calendrier;
	private Map<String, List<ImputationDTO>> mapImputation;

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	public Map<String, List<ImputationDTO>> getMapImputation() {
		return mapImputation;
	}

	public void setMapImputation(Map<String, List<ImputationDTO>> mapImputation) {
		this.mapImputation = mapImputation;
	}

}

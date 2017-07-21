package com.ssm.oab.gi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.ImputationRepository;
import com.ssm.oab.gi.dao.entity.Imputation;
import com.ssm.oab.gi.service.dto.Calendrier;
import com.ssm.oab.gi.service.dto.ImputationDTO;
import com.ssm.oab.gi.service.dto.ImputationsDTO;
import com.ssm.oab.gi.service.dto.JourDuMois;
import com.ssm.oab.gi.service.transformer.ImputationTransformer;

@org.springframework.stereotype.Service
public class ImputationService {

	@Autowired
	private ImputationRepository imputationRepository;

	private ImputationTransformer transformer = new ImputationTransformer();

	public Iterable<ImputationDTO> getImputations() {
		Iterable<ImputationDTO> listeImputations = transformer.toDto(imputationRepository.findAll());

		return listeImputations;
	}

	public ImputationsDTO findImputationsByCodeAllianceAndMonth(String codeAlliance, String moisAnnee) {
		Iterable<ImputationDTO> listImputations = transformer
				.toDto(imputationRepository.findImputationsByCodeAlliance(codeAlliance));

		return getImputationsForCurrentMounth(listImputations);
	}

	private ImputationsDTO getImputationsForCurrentMounth(Iterable<ImputationDTO> listImputationsDTO) {
		Map<String, List<ImputationDTO>> mapImputations = new HashMap<>();

		ImputationsDTO imputationsDTO = new ImputationsDTO();

		Calendar currentCalendar = Calendar.getInstance();
		int currentMonth = currentCalendar.get(Calendar.MONTH);

		for (ImputationDTO dto : listImputationsDTO) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dto.getDate());
			int month = calendar.get(Calendar.MONTH);
			if (month == currentMonth) {

				if (mapImputations.containsKey(dto.getCodeProjet())) {
					mapImputations.get(dto.getCodeProjet()).add(dto);
				} else {
					List<ImputationDTO> listeImputation = new ArrayList<>();
					listeImputation.add(dto);
					mapImputations.put(dto.getCodeProjet(), listeImputation);
				}

			}
		}

		imputationsDTO.setCalendrier(getCalendrier());
		imputationsDTO.setMapImputation(mapImputations);
		return imputationsDTO;
	}

	private Calendrier getCalendrier() {
		Calendrier calendrier = new Calendrier();
		SimpleDateFormat fmt = new SimpleDateFormat("MMMMMM");
		Calendar cal = Calendar.getInstance();
		calendrier.setAnnee(cal.get(Calendar.YEAR));
		calendrier.setNomMois(fmt.format(cal.getTime()));
		calendrier.setJoursDuMois(getJoursDuMois(cal));
		calendrier.setNumeroMois(cal.get(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return calendrier;
	}

	private List<JourDuMois> getJoursDuMois(Calendar cal) {
		List<JourDuMois> res = new ArrayList<>();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat fmt = new SimpleDateFormat("EEE");
		JourDuMois jourDuMois = null;
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			jourDuMois = new JourDuMois();
			jourDuMois.setJour(i);
			jourDuMois.setLibelle(fmt.format(cal.getTime()));
			res.add(jourDuMois);
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return res;
	}

	public Imputation getImputation(String id) {
		return imputationRepository.findOne(id);
	}

	public ImputationsDTO create(ImputationsDTO imputationToSave, String codeAlliance) {

		ImputationsDTO dto = init(imputationToSave, codeAlliance);

		List<ImputationDTO> listeImputationDTO = dto.getMapImputation().values().iterator().next();
		for (ImputationDTO imputationDTO : listeImputationDTO) {
			Imputation imputation = transformer.toEntity(imputationDTO);
			imputationRepository.save(imputation);
		}
		return dto;
	}

	private ImputationsDTO init(ImputationsDTO imputationToSave, String codeAlliance) {

		Map<String, List<ImputationDTO>> mapImputation = new HashMap<>();
		List<ImputationDTO> listeImputationDTO = new ArrayList<>();
		ImputationDTO imputationDTO = null;

		imputationToSave.setCalendrier(getCalendrier());
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);

		// for(){
		//
		// }
		for (int i = 1; i <= imputationToSave.getCalendrier().getJoursDuMois().size(); i++) {
			imputationDTO = new ImputationDTO();
			imputationDTO.setJour(0);
			imputationDTO.setDate(cal.getTime());
			imputationDTO.setCodeAlliance(codeAlliance);
			imputationDTO.setCodeProjet(imputationToSave.getMapImputation().keySet().iterator().next());
			cal.add(Calendar.DAY_OF_YEAR, 1);
			listeImputationDTO.add(imputationDTO);
		}
		mapImputation.put("codeProjet", listeImputationDTO);

		imputationToSave.setMapImputation(mapImputation);

		return imputationToSave;
	}

	public Imputation update(Imputation entity) {
		imputationRepository.save(entity);
		return entity;
	}

	public void delete(String id) {
		imputationRepository.delete(id);
	}
}

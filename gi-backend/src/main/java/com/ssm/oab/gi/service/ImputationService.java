package com.ssm.oab.gi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.ImputationRepository;
import com.ssm.oab.gi.dao.entity.Imputation;
import com.ssm.oab.gi.dao.entity.Projet;
import com.ssm.oab.gi.service.dto.Calendrier;
import com.ssm.oab.gi.service.dto.ImputationDTO;
import com.ssm.oab.gi.service.dto.ImputationsDTO;
import com.ssm.oab.gi.service.dto.JourDuMois;
import com.ssm.oab.gi.service.transformer.ImputationTransformer;

@org.springframework.stereotype.Service
public class ImputationService {

	@Autowired
	private ImputationRepository imputationRepository;

	@Autowired
	private ProjetService projetService;

	private ImputationTransformer transformer = new ImputationTransformer();

	public Iterable<ImputationDTO> getImputations() {
		Iterable<ImputationDTO> listeImputations = transformer.toDto(imputationRepository.findAll());

		return listeImputations;
	}

	public List<ImputationsDTO> findImputationsByCodeAllianceAndMonth(String codeAlliance, String moisAnnee) {
		Iterable<ImputationDTO> listImputations = transformer
				.toDto(imputationRepository.findImputationsByCodeAlliance(codeAlliance));

		return getImputationsForCurrentMounth(listImputations, codeAlliance, moisAnnee);
	}

	private List<ImputationsDTO> getImputationsForCurrentMounth(Iterable<ImputationDTO> listImputationsDTO,
			String codeAlliance, String moisAnnee) {
		List<ImputationsDTO> listeImputations = new ArrayList<>();

		int requestedtMonth = Integer.parseInt(moisAnnee.substring(0, 2));
		int requestedtYear = Integer.parseInt(moisAnnee.substring(3, moisAnnee.length()));

		for (int i = 1; i <= 5; i++) {
			ImputationsDTO imputationsDTO = new ImputationsDTO();
			imputationsDTO.setId(i);
			for (ImputationDTO dto : listImputationsDTO) {
				imputationsDTO.setCalendrier(getCalendrier(requestedtMonth, requestedtYear));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dto.getDate());
				int month = calendar.get(Calendar.MONTH) + 1;
				if (month == requestedtMonth && dto.getIdImputations() == i) {
					imputationsDTO.setProjet(new Projet(dto.getCodeProjet()));
					imputationsDTO.getListeImputation().add(dto);
				}
			}
			if (imputationsDTO.getListeImputation().isEmpty()) {
				init(imputationsDTO, codeAlliance, requestedtMonth, requestedtYear, i);
			}
			listeImputations.add(imputationsDTO);
		}
		return listeImputations;
	}

	private Calendrier getCalendrier(int mois, int annee) {
		Calendrier calendrier = new Calendrier();
		SimpleDateFormat fmt = new SimpleDateFormat("MMMMMM");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mois - 1);
		cal.set(Calendar.YEAR, annee);
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
		int nbJoursMois = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= nbJoursMois; i++) {
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

	public ImputationsDTO create(ImputationsDTO imputationToSave, String codeAlliance, String moisAnnee) {

		ImputationsDTO dto = null;// init(imputationToSave, codeAlliance,
									// moisAnnee);

		List<ImputationDTO> listeImputationDTO = dto.getListeImputation();
		for (ImputationDTO imputationDTO : listeImputationDTO) {
			Imputation imputation = transformer.toEntity(imputationDTO);
			imputationRepository.save(imputation);
		}
		return dto;
	}

	private void init(ImputationsDTO imputationToSave, String codeAlliance, int mois, int annee, int idImputations) {

		List<ImputationDTO> listeImputationDTO = new ArrayList<>();
		ImputationDTO imputationDTO = null;

		imputationToSave.setCalendrier(getCalendrier(mois, annee));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mois - 1);
		cal.set(Calendar.YEAR, annee);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 1);

		for (int i = 1; i <= imputationToSave.getCalendrier().getJoursDuMois().size(); i++) {
			imputationDTO = new ImputationDTO();
			imputationDTO.setJour(0);
			imputationDTO.setDate(cal.getTime());
			imputationDTO.setCodeAlliance(codeAlliance);
			imputationDTO.setIdImputations(idImputations);
			if (projetService.getProjets().iterator().hasNext())
				imputationDTO.setCodeProjet(projetService.getProjets().iterator().next().getCodeprojet());
			cal.add(Calendar.DAY_OF_YEAR, 1);
			listeImputationDTO.add(imputationDTO);
		}

		imputationToSave.setListeImputation(listeImputationDTO);

		List<Imputation> listeImputationToSave = transformer.toEntity(imputationToSave.getListeImputation());

		imputationRepository.save(listeImputationToSave);
	}

	public List<ImputationsDTO> update(List<ImputationsDTO> listImputationsDTO, String codeAlliance, String moisAnnee) {
		for (ImputationsDTO dto : listImputationsDTO) {
//			for (ImputationDTO imputationDTO : dto.getListeImputation()) {
//				imputationDTO.setCodeProjet(dto.getProjet().getCodeprojet());
//			}
			List<Imputation> toBeUpdated = transformer.toEntity(dto.getListeImputation());
			imputationRepository.save(toBeUpdated);
		}
		return findImputationsByCodeAllianceAndMonth(codeAlliance, moisAnnee);
	}

	public void delete(String id) {
		imputationRepository.delete(id);
	}
}

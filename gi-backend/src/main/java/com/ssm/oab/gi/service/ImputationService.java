package com.ssm.oab.gi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.ImputationRepository;
import com.ssm.oab.gi.dao.entity.Imputation;
import com.ssm.oab.gi.service.dto.ImputationDTO;
import com.ssm.oab.gi.service.transformer.ImputationTransformer;

@org.springframework.stereotype.Service
public class ImputationService {

	@Autowired
	private ImputationRepository imputationRepository;

	private ImputationTransformer transformer = new ImputationTransformer();

	public Iterable<ImputationDTO> getImputations() {
		return transformer.toDto(imputationRepository.findAll());
	}

	public List<ImputationDTO> findImputationsByUserForCurrentMounth() {
		Iterable<ImputationDTO> listImputations = transformer
				.toDto(imputationRepository.findImputationsByCodeAlliance("abcd1234"));

		return getImputationsForCurrentMounth(listImputations);
	}

	public Imputation getImputation(String id) {
		return imputationRepository.findOne(id);
	}

	public ImputationDTO create(ImputationDTO imputationToSave) {
		Imputation imputationSaved = null;
		try {
			imputationSaved = imputationRepository.save(transformer.toEntity(imputationToSave));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return transformer.toDto(imputationSaved);
	}

	public Imputation update(Imputation entity) {
		imputationRepository.save(entity);
		return entity;
	}

	public void delete(String id) {
		imputationRepository.delete(id);
	}

	private List<ImputationDTO> getImputationsForCurrentMounth(Iterable<ImputationDTO> listImputationsDTO) {
		List<ImputationDTO> listImputations = new ArrayList<>();
		
		Calendar currentCalendar = Calendar.getInstance();
		int currentMonth = currentCalendar.get(Calendar.MONTH);

		for (ImputationDTO dto : listImputationsDTO) {
			Calendar calendar = dto.getDate();
			int month = calendar.get(Calendar.MONTH);
			if (month == currentMonth) {
				listImputations.add(dto);
			}
		}

		return listImputations;
	}
}
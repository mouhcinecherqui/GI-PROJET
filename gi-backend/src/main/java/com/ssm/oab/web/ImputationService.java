package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ImputationService {

	@Autowired
	private ImputationRepository imputationRepository;

	public Iterable<Imputation> getImputations() {
		return imputationRepository.findAll();
	}

	public Imputation getImputation(String id) {
		return imputationRepository.findOne(id);
	}

	public Imputation create(Imputation imputationToSave) {
		imputationRepository.save(imputationToSave);
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

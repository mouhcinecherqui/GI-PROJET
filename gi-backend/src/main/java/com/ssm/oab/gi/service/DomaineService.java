package com.ssm.oab.gi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.DomaineRepository;
import com.ssm.oab.gi.dao.entity.Domaine;

@org.springframework.stereotype.Service
public class DomaineService {

	@Autowired
	private DomaineRepository domaineRepository;

	public Iterable<Domaine> getDomaines() {
		return domaineRepository.findAll();
	}

	public Domaine getDomaine(String dmn) {
		return domaineRepository.findOne(dmn);
	}

	public Domaine create(Domaine domaineToSave) {
		domaineRepository.save(domaineToSave);
		return domaineToSave;
	}

	public Domaine update(Domaine entity) {
		domaineRepository.save(entity);
		return entity;
	}

	public void delete(String dmn) {
		domaineRepository.delete(dmn);
	}

}

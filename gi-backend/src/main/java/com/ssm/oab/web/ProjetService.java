package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ProjetService {

	@Autowired
	private ProjetRepository projetRepository;

	public Iterable<Projet> getProjets() {
		return projetRepository.findAll();
	}

	public Projet getProjet(String codeprojet) {
		return projetRepository.findOne(codeprojet);
	}

	public Projet create(Projet projetToSave) {
		projetRepository.save(projetToSave);
		return projetToSave;
	}

	public Projet update(Projet entity) {
		projetRepository.save(entity);
		return entity;
	}

	public void delete(String codeprojet) {
		projetRepository.delete(codeprojet);
	}

}

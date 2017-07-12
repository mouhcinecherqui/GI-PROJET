package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProjetController {

	@Autowired
	private ProjetService service;

	@RequestMapping(value = "/projets")
	public Iterable<Projet> getProjets() {
		return service.getProjets();
	}

	@RequestMapping(value = "/projets/{codeprojet}")
	public Projet getProjet(@PathVariable(value = "codeprojet") String codeprojet) {
		return service.getProjet(codeprojet);
	}

	@RequestMapping(value = "/projets/{codeprojet}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "codeprojet") String codeprojet) {
		service.delete(codeprojet);
	}

	@RequestMapping(value = "/projets/{codeprojet}", method = RequestMethod.PUT)
	public void update(@RequestBody Projet projet) {
		service.update(projet);
	}

	@RequestMapping(value = "/projets", method = RequestMethod.POST)
	public Projet create(@RequestBody Projet projetToSave) {
		return service.create(projetToSave);
	}
}

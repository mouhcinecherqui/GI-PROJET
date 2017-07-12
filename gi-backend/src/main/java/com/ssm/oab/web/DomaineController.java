package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DomaineController {
	@Autowired
	private DomaineService service;

	@RequestMapping(value = "/domaines")
	public Iterable<Domaine> getDomaines() {
		return service.getDomaines();
	}

	@RequestMapping(value = "/domaines/{dmn}")
	public Domaine getDomaine(@PathVariable(value = "dmn") String domaine) {
		return service.getDomaine(domaine);
	}

	@RequestMapping(value = "/domaines/{dmn}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "dmn") String domaine) {
		service.delete(domaine);
	}

	@RequestMapping(value = "/domaines/{dmn}", method = RequestMethod.PUT)
	public void update(@RequestBody Domaine domaine) {
		service.update(domaine);
	}

	@RequestMapping(value = "/domaines", method = RequestMethod.POST)
	public Domaine create(@RequestBody Domaine domaineToSave) {
		return service.create(domaineToSave);
	}
}
package com.ssm.oab.gi.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.oab.gi.dao.entity.Imputation;
import com.ssm.oab.gi.service.ImputationService;
import com.ssm.oab.gi.service.dto.ImputationDTO;

@RestController
@RequestMapping(value = "/api")
public class ImputationController {
	@Autowired
	private ImputationService service;

	@RequestMapping(value = "/imputations")
	public Iterable<ImputationDTO> getImputations() {
		return service.getImputations();
	}

	@RequestMapping(value = "/imputations/mounth")
	public Iterable<ImputationDTO> findImputationsCodeAllianceForCurrentMounth(@RequestParam String codeAlliance) {
		return service.findImputationsByUserForCurrentMounth();
	}

	@RequestMapping(value = "/imputations/{id}")
	public Imputation getImputation(@PathVariable(value = "id") String imputation) {
		return service.getImputation(imputation);
	}

	@RequestMapping(value = "/imputations/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String imputation) {
		service.delete(imputation);
	}

	@RequestMapping(value = "/imputations/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Imputation imputation) {
		service.update(imputation);
	}

	@RequestMapping(value = "/imputations", method = RequestMethod.POST)
	public ImputationDTO create(@RequestBody ImputationDTO imputationToSave) {
		return service.create(imputationToSave);
	}
}
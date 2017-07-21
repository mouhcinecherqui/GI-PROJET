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
import com.ssm.oab.gi.service.dto.ImputationsDTO;

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
	public ImputationsDTO findImputationByCodeAllianceAndMonth(@RequestParam String codeAlliance,
			@RequestParam String moisAnnee) {

		return service.findImputationsByCodeAllianceAndMonth(codeAlliance, moisAnnee);
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

	@RequestMapping(value = "/imputations/{codeAlliance}", method = RequestMethod.POST)
	public ImputationsDTO create(@PathVariable(value = "codeAlliance") String codeAlliance,
			@RequestBody ImputationsDTO imputationsToSave) {
		return service.create(imputationsToSave, codeAlliance);
	}
}
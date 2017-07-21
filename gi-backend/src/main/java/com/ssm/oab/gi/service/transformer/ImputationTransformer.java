package com.ssm.oab.gi.service.transformer;

import java.util.ArrayList;
import java.util.List;

import com.ssm.oab.gi.dao.entity.Imputation;
import com.ssm.oab.gi.service.dto.ImputationDTO;

public class ImputationTransformer {

	public ImputationDTO toDto(Imputation entity) {

		ImputationDTO dto = new ImputationDTO();
		if (entity != null) {
			dto.setCodeAlliance(entity.getCodeAlliance());
			dto.setCodeProjet(entity.getCodeProjet());
			dto.setDate(entity.getDate());
			dto.setId(entity.getId());
			dto.setJour(entity.getJour());
		}
		return dto;
	}

	public List<ImputationDTO> toDto(Iterable<Imputation> entityList) {

		List<ImputationDTO> dtoList = new ArrayList<>();
		ImputationDTO dto = null;
		for (Imputation entity : entityList) {
			if (entity != null) {
				dto = toDto(entity);
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	public Imputation toEntity(ImputationDTO dto) {
		Imputation entity = new Imputation();

		if (dto != null) {
			entity.setDate(dto.getDate());
			entity.setJour(dto.getJour());
			entity.setCodeProjet(dto.getCodeProjet());
			entity.setCodeAlliance(dto.getCodeAlliance());
		}

		return entity;
	}
}

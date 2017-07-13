package com.ssm.oab.gi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssm.oab.gi.dao.entity.Imputation;

@Repository
public interface ImputationRepository extends CrudRepository<Imputation, String> {

	public List<Imputation> findImputationsByCodeAlliance(String codeAlliance);

}

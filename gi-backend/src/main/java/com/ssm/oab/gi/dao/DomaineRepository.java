package com.ssm.oab.gi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssm.oab.gi.dao.entity.Domaine;

@Repository
public interface DomaineRepository extends CrudRepository<Domaine, String>{

}

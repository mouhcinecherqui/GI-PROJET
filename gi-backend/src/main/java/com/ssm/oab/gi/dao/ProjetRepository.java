package com.ssm.oab.gi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssm.oab.gi.dao.entity.Projet;

@Repository
public interface ProjetRepository extends CrudRepository<Projet, String>{

}

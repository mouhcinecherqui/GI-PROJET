package com.ssm.oab.gi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssm.oab.gi.dao.entity.Utilisateur;

@Repository
public interface UserRepository extends CrudRepository<Utilisateur, String>{
	

}

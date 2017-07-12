package com.ssm.oab.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URepository extends CrudRepository<Utilisateur, String>{

}

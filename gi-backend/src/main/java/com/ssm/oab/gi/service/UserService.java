package com.ssm.oab.gi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.UserRepository;
import com.ssm.oab.gi.dao.entity.Utilisateur;

@org.springframework.stereotype.Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<Utilisateur> getUsers() {
		return userRepository.findAll();
	}

	public Utilisateur getUser(String codeAlliance) {
		return userRepository.findOne(codeAlliance);
	}

	public Iterable<Utilisateur> getUsersByDomaine(String dmn) {
		return userRepository.findAllByDmn(dmn);
	}

	public Utilisateur create(Utilisateur utilisateurToSave) {
		userRepository.save(utilisateurToSave);
		return utilisateurToSave;
	}

	public Utilisateur update(Utilisateur entity) {
		userRepository.save(entity);
		return entity;
	}

	public void delete(String codeAlliance) {
		userRepository.delete(codeAlliance);
	}

}

package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UserService {

	@Autowired
	private URepository userRepository;

	public Iterable<Utilisateur> getUsers() {
		return userRepository.findAll();
	}

	public Utilisateur getUser(String codeAlliance) {
		return userRepository.findOne(codeAlliance);
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

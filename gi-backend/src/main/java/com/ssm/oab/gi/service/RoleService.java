package com.ssm.oab.gi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.oab.gi.dao.RoleRepository;
import com.ssm.oab.gi.dao.entity.Role;


@org.springframework.stereotype.Service

public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public Iterable<Role> getRoles() {
		return roleRepository.findAll();
	}

	public Role getRole(String role) {
		return roleRepository.findOne(role);
	}

	public Role create(Role roleToSave) {
		roleRepository.save(roleToSave);
		return roleToSave;
	}

	public Role update(Role entity) {
		roleRepository.save(entity);
		return entity;
	}

	public void delete(String role) {
		roleRepository.delete(role);
	}
}
package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RoleController {
	@Autowired
	private RoleService service;

	@RequestMapping(value = "/roles")
	public Iterable<Role> getRoles() {
		return service.getRoles();
	}

	@RequestMapping(value = "/roles/{role}")
	public Role getRole(@PathVariable(value = "role") String role) {
		return service.getRole(role);
	}

	@RequestMapping(value = "/roles/{role}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "role") String role) {
		service.delete(role);
	}

	@RequestMapping(value = "/roles/{role}", method = RequestMethod.PUT)
	public void update(@RequestBody Role role) {
		service.update(role);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public Role create(@RequestBody Role roleToSave) {
		return service.create(roleToSave);
	}
}
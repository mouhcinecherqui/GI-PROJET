package com.ssm.oab.gi.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.oab.gi.dao.entity.Utilisateur;
import com.ssm.oab.gi.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/users")
	public Iterable<Utilisateur> getUsers(@RequestParam(value = "dmn", required = false) String dmn) {
		if (dmn != null && "ALL".equals(dmn)) {
			return service.getUsers();
		} else if (dmn != null && !dmn.isEmpty()) {
			return service.getUsersByDomaine(dmn);
		} else {
			return service.getUsers();
		}
	}

	@RequestMapping(value = "/authentication")
	public Utilisateur authentication(@RequestParam(value = "codeAlliance") String codeAlliance,
			@RequestParam(value = "password") String password) {
		Utilisateur user = service.getUser(codeAlliance);
		if (password.equals(user.getPassword())) {
			return user;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/users/{codeAlliance}")
	public Utilisateur getUser(@PathVariable(value = "codeAlliance") String codeAlliance) {
		return service.getUser(codeAlliance);
	}

	@RequestMapping(value = "/users/{codeAlliance}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "codeAlliance") String codeAlliance) {
		service.delete(codeAlliance);
	}

	@RequestMapping(value = "/users/{codeAlliance}", method = RequestMethod.PUT)
	public void update(@RequestBody Utilisateur utilisateur) {
		service.update(utilisateur);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public Utilisateur create(@RequestBody Utilisateur utilisateurToSave) {
		return service.create(utilisateurToSave);
	}
}

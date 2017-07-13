package com.ssm.oab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/users")
	public Iterable<Utilisateur> getUsers() {
		return service.getUsers();
	}
	

	@RequestMapping(value = "/authentication")
	public Utilisateur authentication(@RequestParam(value = "codeAlliance") String codeAlliance,@RequestParam(value = "password") String password) {
		Utilisateur user=service.getUser(codeAlliance);
		if(password.equals(user.getPassword())){
			return user;
		}else{
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

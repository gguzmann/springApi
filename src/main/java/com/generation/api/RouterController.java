package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController { // ROUTER
	
	@RequestMapping("/a") //  "/"
	public String index() {
		return "index";
	}
	
	@RequestMapping("/users") // "/user"
	public String users() {
		return "usuarios";
	}

	@RequestMapping("/ususers/inscrito") //
	public String inscritos() {
		return "usuarios inscritos";
	}

	@RequestMapping(value = "/clients/register", method= RequestMethod.GET) //
	public String register() {
		return "usuarios registrado";
	}

}
package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class ParametrosRestController {
	
	@RequestMapping("/")
	public String fecha(@RequestParam(value="fecha") String fecha) {
		return fecha;
	}

	//PARAMETROS OBLIGATORIOS
	@RequestMapping("/seccion")
	public String seccion(@RequestParam(value="id") String seccionId,
			@RequestParam(value="name") String nameSeccion) {
		return seccionId + " " + nameSeccion;
	}

	//PARAMETROS NO OBLIGATORIOS
	//localhost:8080/api/users?user=1&mail=juan@cl
	@RequestMapping("/users")
	public String usuarios(@RequestParam(value="user", required = false) String user,
							@RequestParam(value="mail", required = false) String mail) {
		return user + " " + mail;
	}

}

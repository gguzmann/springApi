package com.generation.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/var") //localhost:8080/var
public class PathVariableRestController {
	
	@RequestMapping("/users/{user}")
	public String captureVarPath(@PathVariable("user") String user) {
		return user;
	}
	
	@RequestMapping("/fecha/{anio}/{mes}/{dia}")
	public String fecha(@PathVariable("anio") String anio,
			@PathVariable("mes") String mes,
			@PathVariable("dia") String dia) {
		return "La fecha es: "+anio+"/"+mes+"/"+dia;
	}

}

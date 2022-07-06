package com.generation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.generation.models.Auto;
import com.generation.services.AutoService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ApiRestController {
	
	@Autowired
	AutoService autoService;
	


    
	@RequestMapping("autos")
	public List<Auto> listaAutos(){
		List<Auto> listaAutos = autoService.findAll();
		
		return listaAutos;
	}

}

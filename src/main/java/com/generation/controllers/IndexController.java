package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Usuario;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("nombre", "Gabriel");
		model.addAttribute("apellido", "Guzman");
		
		return "index.jsp";
	}
	
}

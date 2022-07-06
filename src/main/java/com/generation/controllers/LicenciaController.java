package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;
import com.generation.models.Usuario;
import com.generation.services.LicenciaService;
import com.generation.services.UsuarioService;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {

	@Autowired
	LicenciaService licenciaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@RequestMapping("")
	public String indexLicencia(Model model) {
		
		List<Usuario> listaUsuarios = usuarioService.fiddall();
		List<Licencia> listaLicencias = licenciaService.findall();

		model.addAttribute("listaLicencias", listaLicencias);
		model.addAttribute("listaUsuarios", listaUsuarios);
		model.addAttribute("licencia", new Licencia());
		
		return "licencia.jsp";
	}
	
	@PostMapping("/validar")
	public String validarLicencia(@Valid @ModelAttribute("licencia") Licencia licencia) {
		
		licenciaService.guardar(licencia);
		return "redirect:/licencia/";
	}
}

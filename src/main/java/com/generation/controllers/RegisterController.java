package com.generation.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Usuario;
import com.generation.services.UsuarioService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	// Inyeccion de dependencias
	@Autowired
	UsuarioService usuarioService;

	// FORMULARIO
	@RequestMapping
	public String register(@ModelAttribute("usuario") Usuario usuario) { // ENVIAR OBJETO VACIO
		return "register.jsp";
	}

	// CAPTURAR DATOS
	@PostMapping
	public String registerUser(@Valid @ModelAttribute("usuario") Usuario usuario, // RECIBIR OBJETO CON DATOS
			BindingResult resultado, // PARA TOMAR ERRORES
			Model model) { // MODEL PARA ENVIAR DATOS DESDE CONTROLADOR A JSP

		if (resultado.hasErrors()) { // CAPTURAR ERRORES EN EL INGRESO DE DATOS
			model.addAttribute("msgError", "datos ingresados son incorrectos");
			return "register.jsp";
		}
		System.out.println(usuario.getNombre() + " " + usuario.getApellido() + " edad: " + usuario.getEdad());

		// Enviar objeto al servicio
		usuarioService.saveUsuario(usuario);

		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteUster(@PathVariable("id") Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/";
	}
	/*
	 * @PostMapping("/user/respaldo") public String
	 * registerUserRespaldo(@RequestParam(value="nombre") String nombre,
	 * 
	 * @RequestParam(value="apellido") String apellido,
	 * 
	 * @RequestParam(value="edad") Integer edad) { System.out.println("Usuario: " +
	 * nombre + " " + apellido + " " + edad);
	 * 
	 * return "register.jsp"; }
	 */
}
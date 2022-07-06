package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.models.Auto;
import com.generation.services.AutoService;


@Controller
@RequestMapping("/auto")
public class AutoController {

	@Autowired
	AutoService autoService;
	
	@RequestMapping("")
	public String indexAuto(Model model ) {
		
		List<Auto> listAuto = autoService.getAll();
		model.addAttribute("listAuto", listAuto);
		
		return "indexAuto.jsp";
	}
	
	@RequestMapping("/register")
	public String registerAuto(@ModelAttribute("auto") Auto auto) {
		return "registerAuto.jsp";
	}
	
	@PostMapping("/register/validate")
	public String validateAuto(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("msgError", "Error en ingreso de datos");
			return "registerAuto.jsp";
		}
		
		autoService.addAuto(auto);
		
		return "redirect:/auto";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAuto(@PathVariable("id") Long id) {
		autoService.deleteAuto(id);
		return "redirect:/auto";
	}
	
	@RequestMapping("/edit/{id}")
	public String editarAuto(@PathVariable("id") Long id, Model model) {
		Auto auto = autoService.FindOneAuto(id);
		
		model.addAttribute("auto", auto);
		
		return "editAuto.jsp";
	}
	
	@PostMapping("/edit/validate/{id}")
	public String validarEditarAuto(
			@PathVariable("id") Long id,
			@Valid
			@ModelAttribute("auto") Auto auto,
			BindingResult result,
			Model model) {
		
		autoService.editarAuto(auto, id);
		
		return "redirect:/auto";
	}

	@PostMapping("/buscar")
	public String buscar(@RequestParam(value="marca") String marca, Model model) {
		
		if(marca == "") {
			return "redirect:/auto";
		}
		
		List<Auto> listAuto = autoService.filtrarMarca(marca);
		if(listAuto.size() < 1){
			model.addAttribute("msg", "Marca de auto no existe");
			return "indexAuto.jsp";
		}
		model.addAttribute("listAuto", listAuto);
		
		return "indexAuto.jsp";
	}
	
	@RequestMapping("/pagina/{numeroPagina}")
	public String paginarAutos(@PathVariable("numeroPagina") int numeroPagina, Model model) {
		
		// ITERABLES SIEMPRE PARTEN EN 0
		Page<Auto> listAuto = autoService.paginarAuto(numeroPagina - 1);
		model.addAttribute("listAuto", listAuto);
		
		//Totalpages = total_elementos / LOTE
		model.addAttribute("totalPages", listAuto.getTotalPages());
		
		return "autosPaginados.jsp";
	}
	
	
}

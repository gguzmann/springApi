package com.generation.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
@Transactional
public class AutoService {

	@Autowired
	AutoRepository autoRepository;
	
	public void addAuto(@Valid Auto auto) {
		autoRepository.save(auto);
	}

	public List<Auto> getAll() {
		return autoRepository.findAll();
	}

	public void deleteAuto(Long id) {
		autoRepository.deleteById(id);
	}

	public void editarAuto(@Valid Auto auto, Long id) {
		auto.setId(id);
		autoRepository.save(auto);
	}

	public Auto FindOneAuto(Long id) {
		return autoRepository.findById(id).get();
	}

	public List<Auto> findAll() {
		return autoRepository.findAll();
	}

	public List<Auto> filtrarMarca(String marca) {
		//return autoRepository.filtrarMarca(marca);
		return autoRepository.findAllAutosMarca(marca);
	}

	private static final int LOTE = 5;
	
	public Page<Auto> paginarAuto(int numeroPagina){
		PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE, Sort.Direction.ASC,"color");
		return autoRepository.findAll(pageRequest);
	}
	
}

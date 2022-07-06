package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Licencia;
import com.generation.repositories.LicenciaRepository;

@Service
public class LicenciaService {

	@Autowired
	LicenciaRepository licenciaRepository;


	public void guardar(@Valid Licencia licencia) {
		// TODO Auto-generated method stub

		licenciaRepository.save(licencia);
	}


	public List<Licencia> findall() {
		// TODO Auto-generated method stub
		return licenciaRepository.findAll();
	}
}

package com.helitonvieira.helisistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.helitonvieira.helisistema.domain.Estado;
import com.helitonvieira.helisistema.repositories.EstadoRepository;

public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}

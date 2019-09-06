package com.helitonvieira.helisistema.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;

@Service
public class SubCategoriaService {

	@Autowired
	private SubCategoriaRepository repo;

	public SubCategoria buscar(Integer id) {
	 Optional<SubCategoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}

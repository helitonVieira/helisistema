package com.helitonvieira.helisistema.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;
import com.helitonvieira.helisistema.services.exceptions.DataIntegrityException;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;

@Service
public class SubCategoriaService {

	@Autowired
	private SubCategoriaRepository repo;

	public SubCategoria find(Integer id) {
		Optional<SubCategoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SubCategoria.class.getName()));
	}
	
	public SubCategoria insert(SubCategoria obj) {
		obj.setCod_subcategoria(null);
		return repo.save(obj);
	}

	public SubCategoria update(SubCategoria obj) {
		find(obj.getCod_subcategoria());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma SubCategoria que possui Itens");
		}
	}
	

}

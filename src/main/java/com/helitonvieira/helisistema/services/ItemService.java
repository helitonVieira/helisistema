package com.helitonvieira.helisistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.repositories.ItemRepository;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;

	public Item find(Integer id) {
		Optional<Item> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Codigo: " + id + ", Tipo: = " + Item.class.getName()));
	}

	public Page<Item> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<SubCategoria> subCategorias = subCategoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndSubCategoriasIn(nome, subCategorias, pageRequest);
	}
}
package com.helitonvieira.helisistema.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.dto.ItemDTO;
import com.helitonvieira.helisistema.services.ItemService;
import com.helitonvieira.helisistema.resources.utils.URL;

@RestController
@RequestMapping(value = "/items")
public class ItemResource {

	@Autowired
	private ItemService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> find(@PathVariable Integer id) {
		Item obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ItemDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="subCategorias", defaultValue="") String subCategorias, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="des_item") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(subCategorias);
		Page<Item> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ItemDTO> listDto = list.map(obj -> new ItemDTO(obj));    
		return ResponseEntity.ok().body(listDto);
	
}
	
}

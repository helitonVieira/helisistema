package com.helitonvieira.helisistema.resources;

import java.net.URI;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.services.SubCategoriaService;

@RestController
@RequestMapping(value = "/subCategorias")
public class SubCategoriaResource {

	@Autowired
	private SubCategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SubCategoria> find(@PathVariable Integer id) {
		SubCategoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody SubCategoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getCod_subcategoria()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody SubCategoria obj,@PathVariable Integer id){
		obj.setCod_subcategoria(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
}

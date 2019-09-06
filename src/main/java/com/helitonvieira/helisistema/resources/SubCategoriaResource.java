package com.helitonvieira.helisistema.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.services.SubCategoriaService;

@RestController
@RequestMapping(value = "/subCategoria")
public class SubCategoriaResource {

	@Autowired
	private SubCategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		SubCategoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}

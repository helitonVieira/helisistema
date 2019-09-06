package com.helitonvieira.helisistema.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/subCategoria")
public class SubCategoriaResource {
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "rest esta funcionando";
	}
}

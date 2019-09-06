package com.helitonvieira.helisistema.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helitonvieira.helisistema.domain.SubCategoria;

@RestController
@RequestMapping(value="/subCategoria")
public class SubCategoriaResource {
	@RequestMapping(method=RequestMethod.GET)
	public List<SubCategoria> listar() {
		
		SubCategoria cat1 = new SubCategoria(1,"Informatica");
		SubCategoria cat2 = new SubCategoria(2,"Escritorio");
		List<SubCategoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;
	}
}

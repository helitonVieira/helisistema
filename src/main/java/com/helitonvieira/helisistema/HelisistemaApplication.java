package com.helitonvieira.helisistema;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.repositories.ItemRepository;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;

@SpringBootApplication
public class HelisistemaApplication implements CommandLineRunner {

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelisistemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SubCategoria cat1 = new SubCategoria(null, "Refrigerante");
		SubCategoria cat2 = new SubCategoria(null, "Cerveja");

		Item p1 = new Item(null, "Skol", 4.5, 2.2, "S");
		Item p2 = new Item(null, "Coca lata", 14.5, 6.2, "S");
		Item p3 = new Item(null, "Fanta Laranja", 24.5, 22.2, "S");

		cat1.getItens().addAll(Arrays.asList(p3, p2));
		cat2.getItens().addAll(Arrays.asList(p1));
		
		p1.getSubCategorias().addAll(Arrays.asList(cat2));
		p2.getSubCategorias().addAll(Arrays.asList(cat1));
		p3.getSubCategorias().addAll(Arrays.asList(cat1));

		subCategoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		itemRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}

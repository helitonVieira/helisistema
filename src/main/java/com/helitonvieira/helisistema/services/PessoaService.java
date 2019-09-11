package com.helitonvieira.helisistema.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;



@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id)  {
	 Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado Codigo: " + id + ", Tipo: = " + Pessoa.class.getName()));
	}
}

package com.helitonvieira.helisistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	@Transactional(readOnly=true)
	Pessoa findByEmail(String email);
}

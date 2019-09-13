package com.helitonvieira.helisistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helitonvieira.helisistema.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	
	//@Transactional(readOnly=true)
	//Pessoa findByDes_email(List<String> email);
}

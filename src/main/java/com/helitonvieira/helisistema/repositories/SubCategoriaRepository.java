package com.helitonvieira.helisistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helitonvieira.helisistema.domain.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer>{
	
}



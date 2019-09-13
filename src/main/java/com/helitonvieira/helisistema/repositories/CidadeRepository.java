package com.helitonvieira.helisistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.cod_estado = :estadoId ORDER BY obj.nom_cidade")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);
	
}

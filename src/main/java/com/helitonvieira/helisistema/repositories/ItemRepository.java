package com.helitonvieira.helisistema.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.domain.SubCategoria;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Item obj INNER JOIN obj.cod_subcategoria cat WHERE obj.des_item LIKE %:nome% AND cat IN :subCategorias")
	Page<Item> findDistinctByNomeContainingAndSubCategoriasIn(@Param("nome") String nome, @Param("subCategorias") List<SubCategoria> categorias, Pageable pageRequest);

}


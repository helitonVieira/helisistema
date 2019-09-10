package com.helitonvieira.helisistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.helitonvieira.helisistema.domain.PagamentoPedido;

@Repository
public interface PagamentoPedidoRepository extends JpaRepository<PagamentoPedido, Integer>{

}
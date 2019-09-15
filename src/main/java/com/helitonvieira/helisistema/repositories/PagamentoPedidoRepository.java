package com.helitonvieira.helisistema.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.PagamentoPedido;
import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.domain.Pessoa;

@Repository
public interface PagamentoPedidoRepository extends JpaRepository<PagamentoPedido, Integer>{
		
}

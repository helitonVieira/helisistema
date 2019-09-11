package com.helitonvieira.helisistema.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.repositories.PedidoRepository;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Codigo: " + id + ", Tipo: = " + Pedido.class.getName()));
	}
}

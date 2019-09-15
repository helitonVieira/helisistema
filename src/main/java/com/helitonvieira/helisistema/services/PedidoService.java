package com.helitonvieira.helisistema.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.ItemPedido;
import com.helitonvieira.helisistema.domain.PagamentoBoleto;
import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;
import com.helitonvieira.helisistema.repositories.ItemPedidoRepository;
import com.helitonvieira.helisistema.repositories.PagamentoPedidoRepository;
import com.helitonvieira.helisistema.repositories.PedidoRepository;
import com.helitonvieira.helisistema.security.UserSS;
import com.helitonvieira.helisistema.services.exceptions.AuthorizationException;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoPedidoRepository pagamentoPedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private EmailService emailService;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Codigo: " + id + ", Tipo: = " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setCod_pedido(null);
		obj.setDta_pedido(new Date());
		obj.setCod_pessoa_cliente(pessoaService.find(obj.getCod_pessoa_cliente().getCod_pessoa()));
		obj.setCod_pessoa_vendedor(pessoaService.find(obj.getCod_pessoa_vendedor().getCod_pessoa()));
		obj.getPagamento().setCod_estado_pagto(EstadoPagamento.PENDENTE);
		obj.getPagamento().setCod_pedido(obj);
		if (obj.getPagamento() instanceof PagamentoBoleto) {
			PagamentoBoleto pagto = (PagamentoBoleto) obj.getPagamento();
			boletoService.preencherPagamentoBoleto(pagto, obj.getDta_pedido());
		}
		obj = repo.save(obj);
		pagamentoPedidoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getCod_item_pedido()) {
			ip.setVal_desconto(0.0);
			ip.setCod_item(itemService.find(ip.getCod_item().getCod_item()));
			ip.setVal_total_item(ip.getCod_item().getVal_preco_venda());
			ip.setCod_Pedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getCod_item_pedido());
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Pessoa pessoa =  pessoaService.find(user.getId());
		return repo.findByPessoa(pessoa, pageRequest);
	}
}

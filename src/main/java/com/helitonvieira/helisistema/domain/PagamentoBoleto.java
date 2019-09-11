package com.helitonvieira.helisistema.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends PagamentoPedido {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dta_vencimento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dta_liquidacao;

	public PagamentoBoleto() {
	}

	public PagamentoBoleto(Integer seq_pagamento, EstadoPagamento ind_estado_pagto, Pedido cod_pedido,
			Date dta_vencimento, Date dta_liquidacao) {
		super(seq_pagamento, ind_estado_pagto, cod_pedido);
		this.dta_vencimento = dta_vencimento;
		this.dta_liquidacao = dta_liquidacao;
	}

	public Date getDta_vencimento() {
		return dta_vencimento;
	}

	public void setDta_vencimento(Date dta_vencimento) {
		this.dta_vencimento = dta_vencimento;
	}

	public Date getDta_liquidacao() {
		return dta_liquidacao;
	}

	public void setDta_liquidacao(Date dta_liquidacao) {
		this.dta_liquidacao = dta_liquidacao;
	}

}

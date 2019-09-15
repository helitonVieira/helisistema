package com.helitonvieira.helisistema.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoCheque")
public class PagamentoCheque extends PagamentoPedido {
	private static final long serialVersionUID = 1L;

	private String num_agencia;
	private String num_conta;
	private String num_fone;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dta_cheque;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dta_predatado;

	public PagamentoCheque() {
	}

	public PagamentoCheque(Integer seq_pagamento, EstadoPagamento ind_estado_pagto, Pedido cod_pedido,
			String num_agencia, String num_conta, String num_fone, Date dta_cheque, Date dta_predatado) {
		super(seq_pagamento, ind_estado_pagto, cod_pedido);
		this.num_agencia = num_agencia;
		this.num_conta = num_conta;
		this.num_fone = num_fone;
		this.dta_cheque = dta_cheque;
		this.dta_predatado = dta_predatado;

	}

	public String getNum_agencia() {
		return num_agencia;
	}

	public void setNum_agencia(String num_agencia) {
		this.num_agencia = num_agencia;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public String getNum_fone() {
		return num_fone;
	}

	public void setNum_fone(String num_fone) {
		this.num_fone = num_fone;
	}

	public Date getDta_cheque() {
		return dta_cheque;
	}

	public void setDta_cheque(Date dta_cheque) {
		this.dta_cheque = dta_cheque;
	}

	public Date getDta_predatado() {
		return dta_predatado;
	}

	public void setDta_predatado(Date dta_predatado) {
		this.dta_predatado = dta_predatado;
	}

}

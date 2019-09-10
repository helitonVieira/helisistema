package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // joined uma tabela para cada SingleTable uma unica tabela
public abstract class PagamentoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer seq_pagamento;

	private Integer cod_estado_pagto;

	@JoinColumn(name = "cod_pedido")
	@OneToOne
	@MapsId
	private Pedido cod_pedido;
	
	public PagamentoPedido() {		
	}
	
	public PagamentoPedido(Integer seq_pagamento, EstadoPagamento ind_estado_pagto, Pedido cod_pedido) {
		super();
		this.seq_pagamento = seq_pagamento;
		this.cod_estado_pagto = ind_estado_pagto.getCod_estado_pagto();
		this.cod_pedido = cod_pedido;
	}

	public Integer getSeq_pagamento() {
		return seq_pagamento;
	}

	public void setSeq_pagamento(Integer seq_pagamento) {
		this.seq_pagamento = seq_pagamento;
	}

	

	public EstadoPagamento getCod_estado_pagto() {
		return EstadoPagamento.toEnum(cod_estado_pagto);
	}
	
	public void setCod_estado_pagto(EstadoPagamento ind_estado_pagto) {
		this.cod_estado_pagto = ind_estado_pagto.getCod_estado_pagto();
	}

	public Pedido getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Pedido cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seq_pagamento == null) ? 0 : seq_pagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentoPedido other = (PagamentoPedido) obj;
		if (seq_pagamento == null) {
			if (other.seq_pagamento != null)
				return false;
		} else if (!seq_pagamento.equals(other.seq_pagamento))
			return false;
		return true;
	}

	
	
	
}

package com.helitonvieira.helisistema.domain;

import javax.persistence.Entity;

import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;

@Entity 
	public class PagamentoCartao extends PagamentoPedido { 
		 private static final long serialVersionUID = 1L;  
		 
		 private Integer num_parcela; 
		 
		 public PagamentoCartao() {			 
		 }

		public PagamentoCartao(Integer seq_pagamento, EstadoPagamento ind_estado_pagto, Pedido cod_pedido, Integer num_parcela) {
			super(seq_pagamento, ind_estado_pagto, cod_pedido);
			this.num_parcela = num_parcela ; 
		}

		public Integer getNum_parcela() {
			return num_parcela;
		}

		public void setNum_parcela(Integer num_parcela) {
			this.num_parcela = num_parcela;
		}
		 
		 

}

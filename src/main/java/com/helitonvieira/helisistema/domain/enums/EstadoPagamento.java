package com.helitonvieira.helisistema.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente","P"),
	QUITADO(2,"Quitado","Q"),
	CANCELADO(3,"Cancelado","C");
	
	private Integer cod_estado_pagto;
	private String des_estado_pagto;
	private String sgl_estado_pagto;
	
	private EstadoPagamento(int cod_estado_pagto,String des_estado_pagto,String sgl_estado_pagto) {
		this.cod_estado_pagto = cod_estado_pagto;
		this.des_estado_pagto = des_estado_pagto;
		this.sgl_estado_pagto = sgl_estado_pagto;
	}
	
	public int getCod_estado_pagto() {
		return cod_estado_pagto;
	}
	public String getDes_estado_pagto() {
		return des_estado_pagto;
	}
	public String getSgl_estado_pagto() {
		return sgl_estado_pagto;
	}
	
	public static EstadoPagamento toEnum(Integer cod_estado_pagto) {
		if (cod_estado_pagto  == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod_estado_pagto.equals(x.getCod_estado_pagto())) {
				return x ;
			}
		}
		throw new IllegalArgumentException("Codigo Estado do Pagamento Inválido:" + cod_estado_pagto);
	}


}

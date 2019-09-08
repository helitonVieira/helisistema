package com.helitonvieira.helisistema.domain.enums;

public enum TipoPessoa {

	PESSOAFISICA(1,"Pessoa Física","F"),
	PESSOAJURIDICA(1,"Pessoa Jurídica","J");
	
	private Integer cod_tipo_pessoa;
	private String des_tipo_pessoa;
	private String sgl_tipo_pessoa;
	
	private TipoPessoa(int cod_tipo_pessoa,String des_tipo_pessoa,String sgl_tipo_pessoa) {
		this.cod_tipo_pessoa = cod_tipo_pessoa;
		this.des_tipo_pessoa = des_tipo_pessoa;
		this.sgl_tipo_pessoa = sgl_tipo_pessoa;
	}
	
	public int getCod_tipo_pessoa() {
		return cod_tipo_pessoa;
	}
	public String getDes_tipo_pessoa() {
		return des_tipo_pessoa;
	}
	public String getSgl_tipo_pessoa() {
		return sgl_tipo_pessoa;
	}
	
	public static TipoPessoa toEnum(Integer cod_tipo_pessoa) {
		if (cod_tipo_pessoa  == null) {
			return null;
		}
		for (TipoPessoa x : TipoPessoa.values()) {
			if (cod_tipo_pessoa.equals(x.getCod_tipo_pessoa())) {
				return x ;
			}
		}
		throw new IllegalArgumentException("Codigo Tipo Pessoa Inválido:" + cod_tipo_pessoa);
	}
}

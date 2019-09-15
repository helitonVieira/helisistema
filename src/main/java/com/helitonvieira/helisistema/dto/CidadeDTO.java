	package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import com.helitonvieira.helisistema.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cod_cidade;
	private String nom_cidade;
	
	public CidadeDTO() {
	}

	public CidadeDTO(Cidade obj) {
		cod_cidade = obj.getCod_cidade();
		nom_cidade = obj.getNom_cidade();
	}

	public Integer getCod_cidade() {
		return cod_cidade;
	}

	public void setCod_cidade(Integer cod_cidade) {
		this.cod_cidade = cod_cidade;
	}

	public String getNom_cidade() {
		return nom_cidade;
	}

	public void setNom_cidade(String nom_cidade) {
		this.nom_cidade = nom_cidade;
	}

	
}

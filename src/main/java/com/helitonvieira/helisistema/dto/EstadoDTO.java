package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import com.helitonvieira.helisistema.domain.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cod_estado;
	private String nom_estado;
	private String sgl_estado;
	private String nom_pais;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Estado obj) {
		cod_estado = obj.getCod_estado();
		nom_estado = obj.getNom_estado();
		sgl_estado = obj.getSgl_estado();
		nom_pais = obj.getNom_pais();
	}
	
	public Integer getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(Integer cod_estado) {
		this.cod_estado = cod_estado;
	}

	public String getNom_estado() {
		return nom_estado;
	}

	public void setNom_estado(String nom_estado) {
		this.nom_estado = nom_estado;
	}

	public String getSgl_estado() {
		return sgl_estado;
	}

	public void setSgl_estado(String sgl_estado) {
		this.sgl_estado = sgl_estado;
	}

	public String getNom_pais() {
		return nom_pais;
	}

	public void setNom_pais(String nom_pais) {
		this.nom_pais = nom_pais;
	}

	
}

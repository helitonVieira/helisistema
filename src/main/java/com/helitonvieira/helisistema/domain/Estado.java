package com.helitonvieira.helisistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_estado;
	private String nom_estado;
	private String sgl_estado;
	private String nom_pais;

	@JsonIgnore
	@OneToMany(mappedBy = "cod_estado")
	private List<Cidade> cidades = new ArrayList<>();

	public Estado() {

	}

	public Estado(Integer cod_estado, String nom_estado, String sgl_estado, String nom_pais) {
		super();
		this.cod_estado = cod_estado;
		this.nom_estado = nom_estado;
		this.sgl_estado = sgl_estado;
		this.nom_pais = nom_pais;
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_estado == null) ? 0 : cod_estado.hashCode());
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
		Estado other = (Estado) obj;
		if (cod_estado == null) {
			if (other.cod_estado != null)
				return false;
		} else if (!cod_estado.equals(other.cod_estado))
			return false;
		return true;
	}

}

package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer cod_cidade;
	private String nom_cidade;
	
	@ManyToOne
	@JoinColumn(name="cod_estado")
	private Estado cod_estado;
	
	public Cidade() {
		
	}

	
	public Cidade(Integer cod_cidade, String nom_cidade, Estado cod_estado) {
		super();
		this.cod_cidade = cod_cidade;
		this.nom_cidade = nom_cidade;
		this.cod_estado = cod_estado;
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

	public Estado getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(Estado cod_estado) {
		this.cod_estado = cod_estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_cidade == null) ? 0 : cod_cidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cod_cidade == null) {
			if (other.cod_cidade != null)
				return false;
		} else if (!cod_cidade.equals(other.cod_cidade))
			return false;
		return true;
	}

	
}

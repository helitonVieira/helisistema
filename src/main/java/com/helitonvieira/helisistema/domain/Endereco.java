package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
   @Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_endereco;
	private String des_logradouro;
	private String des_num_logradouro;
	private String des_complemento;
	private String des_bairro;
	private String num_cep;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cod_pessoa")
	private Pessoa cod_pessoa;
	
	@ManyToOne
	@JoinColumn(name = "cod_cidade")
	private Cidade cod_cidade;
	
	public Endereco(Integer cod_endereco, String des_logradouro,String des_num_logradouro, String des_complemento, String des_bairro,
			String num_cep, Pessoa cod_pessoa, Cidade cod_cidade) {
		super();
		this.cod_endereco = cod_endereco;
		this.des_logradouro = des_logradouro;
		this.des_num_logradouro = des_num_logradouro;
		this.des_complemento = des_complemento;
		this.des_bairro = des_bairro;
		this.num_cep = num_cep;
		this.cod_pessoa = cod_pessoa;
		this.cod_cidade = cod_cidade;
	}

	public Endereco() {		
	}

	public Integer getCod_endereco() {
		return cod_endereco;
	}

	public void setCod_endereco(Integer cod_endereco) {
		this.cod_endereco = cod_endereco;
	}
	
	public String getDes_logradouro() {
		return des_logradouro;
	}

	public void setDes_logradouro(String des_logradouro) {
		this.des_logradouro = des_logradouro;
	}

	public String getDes_num_logradouro() {
		return des_num_logradouro;
	}

	public void setDes_num_logradouro(String des_num_logradouro) {
		this.des_num_logradouro = des_num_logradouro;
	}
	
	public String getDes_complemento() {
		return des_complemento;
	}

	public void setDes_complemento(String des_complemento) {
		this.des_complemento = des_complemento;
	}

	public String getDes_bairro() {
		return des_bairro;
	}

	public void setDes_bairro(String des_bairro) {
		this.des_bairro = des_bairro;
	}

	public String getNum_cep() {
		return num_cep;
	}

	public void setNum_cep(String num_cep) {
		this.num_cep = num_cep;
	}

	public Pessoa getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(Pessoa cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}
	
	public Cidade getCod_cidade() {
		return cod_cidade;
	}

	public void setCod_cidade(Cidade cod_cidade) {
		this.cod_cidade = cod_cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_endereco == null) ? 0 : cod_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cod_endereco == null) {
			if (other.cod_endereco != null)
				return false;
		} else if (!cod_endereco.equals(other.cod_endereco))
			return false;
		return true;
	}
	
	
}

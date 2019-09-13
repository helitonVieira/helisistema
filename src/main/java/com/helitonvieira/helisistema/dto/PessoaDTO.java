package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.helitonvieira.helisistema.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cod_pessoa;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho tem que ser entre 5 e 120 caracteres")
	private String nom_pessoa;

	private String nom_fantasia;
	private String num_cnpj_cpf;
	private String num_ie_rg;

	private String dta_nascimento;
	private String nom_responsavel;
	private String des_observacao;

	private String dta_cadastro;
	private String ind_cliente;
	private String ind_fornecedor;
	private String ind_funcionario;
	private String ind_ativo;

	public PessoaDTO() {

	}

	public PessoaDTO(Pessoa obj) {

		cod_pessoa = obj.getCod_pessoa();
		nom_pessoa = obj.getNom_pessoa();
		nom_fantasia = obj.getNom_fantasia();
		num_cnpj_cpf = obj.getNum_cnpj_cpf();
		num_ie_rg = obj.getNum_ie_rg();
		dta_nascimento = obj.getDta_nascimento();
		nom_responsavel = obj.getNom_responsavel();
		des_observacao = obj.getDes_observacao();
		dta_cadastro = obj.getDta_cadastro();
		ind_cliente = obj.getInd_cliente();
		ind_fornecedor = obj.getInd_fornecedor();
		ind_funcionario = obj.getInd_funcionario();
		ind_ativo = obj.getInd_ativo();
	}


	public Integer getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(Integer cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}

	public String getNom_pessoa() {
		return nom_pessoa;
	}

	public void setNom_pessoa(String nom_pessoa) {
		this.nom_pessoa = nom_pessoa;
	}

	public String getNom_fantasia() {
		return nom_fantasia;
	}

	public void setNom_fantasia(String nom_fantasia) {
		this.nom_fantasia = nom_fantasia;
	}

	public String getNum_cnpj_cpf() {
		return num_cnpj_cpf;
	}

	public void setNum_cnpj_cpf(String num_cnpj_cpf) {
		this.num_cnpj_cpf = num_cnpj_cpf;
	}

	public String getNum_ie_rg() {
		return num_ie_rg;
	}

	public void setNum_ie_rg(String num_ie_rg) {
		this.num_ie_rg = num_ie_rg;
	}

	public String getDta_nascimento() {
		return dta_nascimento;
	}

	public void setDta_nascimento(String dta_nascimento) {
		this.dta_nascimento = dta_nascimento;
	}

	public String getNom_responsavel() {
		return nom_responsavel;
	}

	public void setNom_responsavel(String nom_responsavel) {
		this.nom_responsavel = nom_responsavel;
	}

	public String getDes_observacao() {
		return des_observacao;
	}

	public void setDes_observacao(String des_observacao) {
		this.des_observacao = des_observacao;
	}

	public String getDta_cadastro() {
		return dta_cadastro;
	}

	public void setDta_cadastro(String dta_cadastro) {
		this.dta_cadastro = dta_cadastro;
	}

	public String getInd_cliente() {
		return ind_cliente;
	}

	public void setInd_cliente(String ind_cliente) {
		this.ind_cliente = ind_cliente;
	}

	public String getInd_fornecedor() {
		return ind_fornecedor;
	}

	public void setInd_fornecedor(String ind_fornecedor) {
		this.ind_fornecedor = ind_fornecedor;
	}

	public String getInd_funcionario() {
		return ind_funcionario;
	}

	public void setInd_funcionario(String ind_funcionario) {
		this.ind_funcionario = ind_funcionario;
	}

	public String getInd_ativo() {
		return ind_ativo;
	}

	public void setInd_ativo(String ind_ativo) {
		this.ind_ativo = ind_ativo;
	}

}

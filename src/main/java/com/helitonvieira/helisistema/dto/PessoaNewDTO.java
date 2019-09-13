package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.helitonvieira.helisistema.services.validation.PessoaInsert;

@PessoaInsert
public class PessoaNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nom_pessoa;
	private String nom_fantasia;
	private String num_cnpj_cpf;
	private String num_ie_rg;

	// @Temporal(TemporalType.DATE)
	private String dta_nascimento;
	private String nom_responsavel;
	private String des_observacao;

	// @Temporal(TemporalType.TIMESTAMP)
	private String dta_cadastro;
	private String ind_cliente;
	private String ind_fornecedor;
	private String ind_funcionario;
	private String ind_ativo;
	private Integer cod_tipo_pessoa;
	
	private String des_logradouro;
	private String des_num_logradouro;
	private String des_complemento;
	private String des_bairro;
	private String num_cep;

	@NotEmpty(message="Preenchimento obrigatório")
	private String num_fone1;
	private String num_fone2;
	private String num_fone3;
	
	@Email(message="Email inválido")
	private String des_email1;
	
	@Email(message="Email inválido")
	private String des_email2;
	
	@Email(message="Email inválido")
	private String des_email3;
	
	private Integer cod_cidade;
	
	public PessoaNewDTO() {
		
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

	public Integer getCod_tipo_pessoa() {
		return cod_tipo_pessoa;
	}

	public void setCod_tipo_pessoa(Integer cod_tipo_pessoa) {
		this.cod_tipo_pessoa = cod_tipo_pessoa;
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

	public String getNum_fone1() {
		return num_fone1;
	}

	public void setNum_fone1(String num_fone1) {
		this.num_fone1 = num_fone1;
	}

	public String getNum_fone2() {
		return num_fone2;
	}

	public void setNum_fone2(String num_fone2) {
		this.num_fone2 = num_fone2;
	}

	public String getNum_fone3() {
		return num_fone3;
	}

	public void setNum_fone3(String num_fone3) {
		this.num_fone3 = num_fone3;
	}

	public String getDes_email1() {
		return des_email1;
	}

	public void setDes_email1(String des_email1) {
		this.des_email1 = des_email1;
	}

	public String getDes_email2() {
		return des_email2;
	}

	public void setDes_email2(String des_email2) {
		this.des_email2 = des_email2;
	}

	public String getDes_email3() {
		return des_email3;
	}

	public void setDes_email3(String des_email3) {
		this.des_email3 = des_email3;
	}

	public Integer getCod_cidade() {
		return cod_cidade;
	}

	public void setCod_cidade(Integer cod_cidade) {
		this.cod_cidade = cod_cidade;
	}
	
	

}

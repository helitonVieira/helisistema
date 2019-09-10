package com.helitonvieira.helisistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.helitonvieira.helisistema.domain.enums.TipoPessoa;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_pessoa;
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
	private Integer cod_tipo_pessoa;// foi criado da class tipo depois alterado para integer

	@JsonManagedReference
	@OneToMany(mappedBy = "cod_pessoa")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "Telefone")
	private Set<String> num_fone = new HashSet<>();// set é um conjunto de string que nao aceita repeticao

	@ElementCollection
	@CollectionTable(name = "Email")
	private Set<String> des_email = new HashSet<>();
	
	@OneToMany(mappedBy = "cod_pessoa_cliente")
	private List<Pedido> cod_pessoa_cliente = new ArrayList<>();
	
	@OneToMany(mappedBy = "cod_pessoa_vendedor")
	private List<Pedido> cod_pessoa_vendedor = new ArrayList<>();

	public Pessoa() {

	}

	public Pessoa(Integer cod_pessoa, String nom_pessoa, String nom_fantasia, String num_cnpj_cpf, String num_ie_rg,
			String dta_nascimento, String nom_responsavel, String des_observacao, String dta_cadastro,
			String ind_cliente, String ind_fornecedor, String ind_funcionario, String ind_ativo,
			TipoPessoa cod_tipo_pessoa) {
		super();
		this.cod_pessoa = cod_pessoa;
		this.nom_pessoa = nom_pessoa;
		this.nom_fantasia = nom_fantasia;
		this.num_cnpj_cpf = num_cnpj_cpf;
		this.num_ie_rg = num_ie_rg;
		this.dta_nascimento = dta_nascimento;
		this.nom_responsavel = nom_responsavel;
		this.des_observacao = des_observacao;
		this.dta_cadastro = dta_cadastro;
		this.ind_cliente = ind_cliente;
		this.ind_fornecedor = ind_fornecedor;
		this.ind_funcionario = ind_funcionario;
		this.ind_ativo = ind_ativo;
		this.cod_tipo_pessoa = cod_tipo_pessoa.getCod_tipo_pessoa();
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

	public TipoPessoa getCod_tipo_pessoa() {
		return TipoPessoa.toEnum(cod_tipo_pessoa);
	}

	public void setCod_tipo_pessoa(TipoPessoa cod_tipo_pessoa) {
		this.cod_tipo_pessoa = cod_tipo_pessoa.getCod_tipo_pessoa();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getNum_fone() {
		return num_fone;
	}

	public void setNum_fone(Set<String> num_fone) {
		this.num_fone = num_fone;
	}

	public Set<String> getDes_email() {
		return des_email;
	}

	public void setDes_email(Set<String> des_email) {
		this.des_email = des_email;
	}

	
	
	public List<Pedido> getCod_pessoa_cliente() {
		return cod_pessoa_cliente;
	}

	public void setPedidosCliente(List<Pedido> cod_pessoa_cliente) {
		this.cod_pessoa_cliente = cod_pessoa_cliente;
	}

	
	public List<Pedido> getCod_pessoa_vendedor() {
		return cod_pessoa_vendedor;
	}

	public void setCod_pessoa_vendedor(List<Pedido> cod_pessoa_vendedor) {
		this.cod_pessoa_vendedor = cod_pessoa_vendedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_pessoa == null) ? 0 : cod_pessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cod_pessoa == null) {
			if (other.cod_pessoa != null)
				return false;
		} else if (!cod_pessoa.equals(other.cod_pessoa))
			return false;
		return true;
	}

}

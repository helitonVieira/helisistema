package com.helitonvieira.helisistema.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_pedido;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dta_pedido;

	@JsonManagedReference   
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cod_pedido")
	private PagamentoPedido pagamento;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cod_pessoa_cliente")
	private Pessoa cod_pessoa_cliente;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cod_pessoa_vendedor")
	private Pessoa cod_pessoa_vendedor;

	@ManyToOne
	@JoinColumn(name = "cod_endereco")
	private Endereco cod_endereco_entrega;

	@OneToMany(mappedBy = "id.cod_pedido")
	private Set<ItemPedido> cod_item_pedido = new HashSet<>();
	
	public Pedido() {
	} 

	public Pedido(Integer cod_pedido, Date dta_pedido, Pessoa cod_pessoa_cliente, Pessoa cod_pessoa_vendedor,
			Endereco cod_endereco_entrega) {
		super();
		this.cod_pedido = cod_pedido;
		this.dta_pedido = dta_pedido;
		this.cod_pessoa_cliente = cod_pessoa_cliente;
		this.cod_pessoa_vendedor = cod_pessoa_vendedor;
		this.cod_endereco_entrega = cod_endereco_entrega;
	}

	public Integer getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Integer cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public Date getDta_pedido() {
		return dta_pedido;
	}

	public void setDta_pedido(Date dta_pedido) {
		this.dta_pedido = dta_pedido;
	}

	public PagamentoPedido getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoPedido pagamento) {
		this.pagamento = pagamento;
	}

	public Pessoa getCod_pessoa_cliente() {
		return cod_pessoa_cliente;
	}

	public void setCod_pessoa_cliente(Pessoa cod_pessoa_cliente) {
		this.cod_pessoa_cliente = cod_pessoa_cliente;
	}

	public Pessoa getCod_pessoa_vendedor() {
		return cod_pessoa_vendedor;
	}

	public void setCod_pessoa_vendedor(Pessoa cod_pessoa_vendedor) {
		this.cod_pessoa_vendedor = cod_pessoa_vendedor;
	}

	public Endereco getCod_endereco_entrega() {
		return cod_endereco_entrega;
	}

	public void setCod_endereco_entrega(Endereco cod_endereco_entrega) {
		this.cod_endereco_entrega = cod_endereco_entrega;
	}

	
	public Set<ItemPedido> getCod_item_pedido() {
		return cod_item_pedido;
	}

	public void setCod_item_pedido(Set<ItemPedido> cod_item_pedido) {
		this.cod_item_pedido = cod_item_pedido;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_pedido == null) ? 0 : cod_pedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (cod_pedido == null) {
			if (other.cod_pedido != null)
				return false;
		} else if (!cod_pedido.equals(other.cod_pedido))
			return false;
		return true;
	}

	

}

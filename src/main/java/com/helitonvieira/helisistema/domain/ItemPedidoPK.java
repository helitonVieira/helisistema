package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cod_pedido")
	private Pedido cod_pedido;

	@ManyToOne
	@JoinColumn(name = "cod_item")
	private Item cod_item;

	public ItemPedidoPK() {
			}

	public Pedido getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(Pedido cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public Item getCod_item() {
		return cod_item;
	}

	public void setCod_item(Item cod_item) {
		this.cod_item = cod_item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_item == null) ? 0 : cod_item.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (cod_item == null) {
			if (other.cod_item != null)
				return false;
		} else if (!cod_item.equals(other.cod_item))
			return false;
		if (cod_pedido == null) {
			if (other.cod_pedido != null)
				return false;
		} else if (!cod_pedido.equals(other.cod_pedido))
			return false;
		return true;
	}
	
}

package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Double val_desconto;
	private Double val_acrescimo;
	private Integer qtd_item;
	private Double val_total_item;
	private Integer cod_barra;

	public ItemPedido() {
	}

	public ItemPedido(Pedido cod_pedido, Item cod_item, Double val_desconto, Double val_acrescimo, Integer qtd_item,
			Double val_total_item, Integer cod_barra) {
		super();
		id.setCod_pedido(cod_pedido);
		id.setCod_item(cod_item);
		this.val_desconto = val_desconto;
		this.val_acrescimo = val_acrescimo;
		this.qtd_item = qtd_item;
		this.val_total_item = val_total_item;
		this.cod_barra = cod_barra;
	}

	@JsonIgnore
	public Pedido getCod_pedido() {
		return id.getCod_pedido();
	}

	public Item getCod_item() {
		return id.getCod_item();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getVal_desconto() {
		return val_desconto;
	}

	public void setVal_desconto(Double val_desconto) {
		this.val_desconto = val_desconto;
	}

	public Double getVal_acrescimo() {
		return val_acrescimo;
	}

	public void setVal_acrescimo(Double val_acrescimo) {
		this.val_acrescimo = val_acrescimo;
	}

	public Integer getQtd_item() {
		return qtd_item;
	}

	public void setQtd_item(Integer qtd_item) {
		this.qtd_item = qtd_item;
	}

	public Double getVal_total_item() {
		return val_total_item;
	}

	public void setVal_total_item(Double val_total_item) {
		this.val_total_item = val_total_item;
	}

	public Integer getCod_barra() {
		return cod_barra;
	}

	public void setCod_barra(Integer cod_barra) {
		this.cod_barra = cod_barra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

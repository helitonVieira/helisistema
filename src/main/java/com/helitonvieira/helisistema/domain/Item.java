package com.helitonvieira.helisistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer cod_item;
	private String des_item;
	private Double val_preco_venda;
	private Double val_custo;
	private String ind_ativo;

	@JsonIgnore
	/*
	 * @ManyToMany // muitos para muitos
	 * 
	 * @JoinTable(name = "Produto_Subgrupo", // criar a tabela intermediaria
	 * joinColumns = @JoinColumn(name = "cod_item"), inverseJoinColumns
	 * = @JoinColumn(name = "cod_subcategoria") ) private SubCategoria subCategorias
	 * = new ArrayList<>();
	 */
	@ManyToOne
	@JoinColumn(name = "cod_subcategoria")
	private SubCategoria cod_subcategoria;

	@JsonIgnore
	@OneToMany(mappedBy = "id.cod_item")
	private Set<ItemPedido> cod_item_pedido = new HashSet<>();

	public Item() {

	}

	public Item(Integer cod_item, String des_item, Double val_preco_venda, Double val_custo, String ind_ativo,
			SubCategoria cod_subcategoria) {
		super();
		this.cod_item = cod_item;
		this.des_item = des_item;
		this.val_preco_venda = val_preco_venda;
		this.val_custo = val_custo;
		this.ind_ativo = ind_ativo;
		this.cod_subcategoria = cod_subcategoria;
	}

	@JsonIgnore
	public List<Pedido> getCod_pedido() {
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : cod_item_pedido) {
			lista.add(x.getCod_pedido());
		}
		return lista;
	}

	public Integer getCod_item() {
		return cod_item;
	}

	public void setCod_item(Integer cod_item) {
		this.cod_item = cod_item;
	}

	public String getDes_item() {
		return des_item;
	}

	public void setDes_item(String des_item) {
		this.des_item = des_item;
	}

	public Double getVal_preco_venda() {
		return val_preco_venda;
	}

	public void setVal_preco_venda(Double val_preco_venda) {
		this.val_preco_venda = val_preco_venda;
	}

	public Double getVal_custo() {
		return val_custo;
	}

	public void setVal_custo(Double val_custo) {
		this.val_custo = val_custo;
	}

	public String getInd_ativo() {
		return ind_ativo;
	}

	public void setInd_ativo(String ind_ativo) {
		this.ind_ativo = ind_ativo;
	}

	public SubCategoria getCod_subcategoria() {
		return cod_subcategoria;
	}

	public void setCod_subcategoria(SubCategoria cod_subcategoria) {
		this.cod_subcategoria = cod_subcategoria;
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
		result = prime * result + ((cod_item == null) ? 0 : cod_item.hashCode());
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
		Item other = (Item) obj;
		if (cod_item == null) {
			if (other.cod_item != null)
				return false;
		} else if (!cod_item.equals(other.cod_item))
			return false;
		return true;
	}

}

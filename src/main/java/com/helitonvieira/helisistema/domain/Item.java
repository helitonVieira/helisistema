package com.helitonvieira.helisistema.domain;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


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

	@ManyToMany // muitos para muitos
	@JoinTable(name = "Produto_Subgrupo", // criar a tabela intermediaria
			joinColumns  = @JoinColumn(name = "cod_item"),
			inverseJoinColumns = @JoinColumn(name = "cod_subcategoria")
	)
	 private List<SubCategoria> subCategorias = new ArrayList<>(); 
	
	 public Item() {

	}

	public Item(Integer cod_item, String des_item, Double val_preco_venda, Double val_custo, String ind_ativo) {
		super();
		this.cod_item = cod_item;
		this.des_item = des_item;
		this.val_preco_venda = val_preco_venda;
		this.val_custo = val_custo;
		this.ind_ativo = ind_ativo;
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

	

	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
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

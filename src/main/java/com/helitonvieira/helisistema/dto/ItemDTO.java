package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import com.helitonvieira.helisistema.domain.Item;

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer cod_item;
	private String des_item;
	private Double val_preco_venda;
	private Double val_custo;
	private String ind_ativo;
	
    public ItemDTO() {
    	
    }
    
    public ItemDTO(Item obj) {
    	cod_item = obj.getCod_item();
    	des_item = obj.getDes_item();
    	val_preco_venda = obj.getVal_preco_venda() ;
    	val_custo  = obj.getVal_custo();
    	ind_ativo  = obj.getInd_ativo();	

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
    

}

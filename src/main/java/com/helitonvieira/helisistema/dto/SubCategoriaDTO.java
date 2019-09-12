package com.helitonvieira.helisistema.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.helitonvieira.helisistema.domain.SubCategoria;

public class SubCategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	

private Integer cod_subcategoria;

@NotEmpty(message="Preenchimento obrigatório")
@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
private String des_subcategoria;

public SubCategoriaDTO() {	
}

public SubCategoriaDTO(SubCategoria obj) {
	cod_subcategoria = obj.getCod_subcategoria();
	
	des_subcategoria = obj.getDes_subcategoria();
	
}

public Integer getCod_subcategoria() {
	return cod_subcategoria;
}

public void setCod_subcategoria(Integer cod_subcategoria) {
	this.cod_subcategoria = cod_subcategoria;
}

public String getDes_subcategoria() {
	return des_subcategoria;
}

public void setDes_subcategoria(String des_subcategoria) {
	this.des_subcategoria = des_subcategoria;
}


}

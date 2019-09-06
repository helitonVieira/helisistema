package com.helitonvieira.helisistema.domain;

import java.io.Serializable;

public class SubCategoria implements Serializable{

	private static final long serialVersionUID = 1L;
private Integer cod_subcategoria;
private String des_subcategoria;

public SubCategoria() {
	}

public SubCategoria(Integer cod_subcategoria, String des_subcategoria) {
	super();
	this.cod_subcategoria = cod_subcategoria;
	this.des_subcategoria = des_subcategoria;
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cod_subcategoria == null) ? 0 : cod_subcategoria.hashCode());
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
	SubCategoria other = (SubCategoria) obj;
	if (cod_subcategoria == null) {
		if (other.cod_subcategoria != null)
			return false;
	} else if (!cod_subcategoria.equals(other.cod_subcategoria))
		return false;
	return true;
}

}

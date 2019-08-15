package com.aguiardafa.eagletavern.model;

public enum GrupoUser {

	ADM("Administrador"),
	VEND("Vendedor");
	
	private final String descricao;
	
	GrupoUser(String descricao) {
    	this.descricao = descricao;
    }
	
	public String getDescricao(){
        return descricao;
    }
}

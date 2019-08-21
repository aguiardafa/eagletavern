package com.aguiardafa.eagletavern.model;

public enum UserGroup {

	ADM("Administrador"),
	VEND("Vendedor");
	
	private final String descricao;
	
	UserGroup(String descricao) {
    	this.descricao = descricao;
    }
	
	public String getDescricao(){
        return descricao;
    }
}

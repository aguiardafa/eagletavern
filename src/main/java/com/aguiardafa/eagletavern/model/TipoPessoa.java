package com.aguiardafa.eagletavern.model;

public enum TipoPessoa {

	FISICA("Pessoa Física"),
	JURUDICA("Pessoa Jurídica");
	
	private final String descricao;
	
	TipoPessoa(String descricao) {
    	this.descricao = descricao;
    }
	
	public String getDescricao(){
        return descricao;
    }
}

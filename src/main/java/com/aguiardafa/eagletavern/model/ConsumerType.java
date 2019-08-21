package com.aguiardafa.eagletavern.model;

public enum ConsumerType {

	FISICA("Pessoa Física"),
	JURUDICA("Pessoa Jurídica");
	
	private final String descricao;
	
	ConsumerType(String descricao) {
    	this.descricao = descricao;
    }
	
	public String getDescricao(){
        return descricao;
    }
}

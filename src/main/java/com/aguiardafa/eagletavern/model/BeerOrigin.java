package com.aguiardafa.eagletavern.model;

public enum BeerOrigin {

	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private final String descricao;
	
	BeerOrigin(String descricao) {
    	this.descricao = descricao;
    }
	
	public String getDescricao(){
        return descricao;
    }
}

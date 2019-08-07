package com.aguiardafa.eagletavern.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Beer {

	@NotBlank
	@Size(min=4)
	private String sku; //identificar de cervejas
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(max=250)
	private String descricao;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

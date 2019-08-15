package com.aguiardafa.eagletavern.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private LocalDate dataNasc;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private Boolean status; 
	
	private List<GrupoUser> grupos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<GrupoUser> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoUser> grupos) {
		this.grupos = grupos;
	}
}

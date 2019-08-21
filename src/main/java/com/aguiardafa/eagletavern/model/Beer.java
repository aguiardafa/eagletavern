package com.aguiardafa.eagletavern.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cerveja")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "SKU é obrigatório")
	@Size(min=4, message = "O SKU deve ser formado por maiS de 3 caracteres")
	private String sku; //identificar de cervejas
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank
	@Size(min=1, max=50, message = "A descrição deve ser entre 1 e 50 caracteres")
	private String descricao;
	
	private BigDecimal valor;
	
	@Column(name="teor_alcoolico")
	private BigDecimal teorAlcoolico;
	
	private BigDecimal comissao;
	
	@Column(name="quant_estoque")
	private BigDecimal quantEstoque;
	
	@Enumerated(EnumType.STRING)
	private BeerOrigin origem;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public BigDecimal getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(BigDecimal quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public BeerOrigin getOrigem() {
		return origem;
	}

	public void setOrigem(BeerOrigin origem) {
		this.origem = origem;
	}
	
}

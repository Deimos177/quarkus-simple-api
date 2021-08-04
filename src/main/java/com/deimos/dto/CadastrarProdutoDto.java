package com.deimos.dto;

import java.math.BigDecimal;

public class CadastrarProdutoDto {
	
	private String nome;
	
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
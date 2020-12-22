package com.edson.desafio.model.enumeration;

public enum Perfil {

	ADMINISTRADOR("Administrador"), ANALISTA("Analista"), GERENTE("Gerente");

	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}

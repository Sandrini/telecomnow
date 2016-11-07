package br.com.telecomnow.model;

public class Detalhamento {

	private String nome;

	private String descricao;

	public Detalhamento(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

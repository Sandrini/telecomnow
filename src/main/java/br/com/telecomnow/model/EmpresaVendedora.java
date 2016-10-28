package br.com.telecomnow.model;

public class EmpresaVendedora {

    private String nome;
    private String site;
    private Integer probabilidade;

    public EmpresaVendedora(String nome, Integer probabilidade, String site) {
        this.nome = nome;
        this.probabilidade = probabilidade;
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public Integer getProbabilidade() {
        return probabilidade;
    }

    public String getSite() {
        return site;
    }
}

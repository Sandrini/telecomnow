package br.com.telecomnow.model;

public class EmpresaVendedora {

    private String nome;
    private String site;
    private String imagem;

    private CategoriasEmpresasVendedoras categoria;

    public EmpresaVendedora(String nome, CategoriasEmpresasVendedoras categoria, String site, String imagem) {
        this.nome = nome;
        this.categoria = categoria;
        this.site = site;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }


    public String getSite() {
        return site;
    }

    public CategoriasEmpresasVendedoras getCategoria() {
        return categoria;
    }

    public String getImagem() {
        return imagem;
    }
}

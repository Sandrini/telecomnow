package br.com.telecomnow.model;

/**
 * Created by Leonardo on 25/10/2016.
 */
public class ComponenteRegiao {

    private String componente;
    private String regiao;
    private Long quatidadeAderente;
    private Long quatidadeNaoAderente;

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setQuatidadeAderente(Long quatidadeAderente) {
        this.quatidadeAderente = quatidadeAderente;
    }

    public void setQuatidadeNaoAderente(Long quatidadeNaoAderente) {
        this.quatidadeNaoAderente = quatidadeNaoAderente;
    }

    public String getComponente() {
        return componente;
    }

    public String getRegiao() {
        return regiao;
    }

    public Long getQuatidadeAderente() {
        return quatidadeAderente;
    }

    public Long getQuatidadeNaoAderente() {
        return quatidadeNaoAderente;
    }


}

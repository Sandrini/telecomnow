package br.com.telecomnow.model;

/**
 * Created by lcdias on 27/10/2016.
 */
public class SomaAderencias {

    private final Long somaAderente;
    private final Long somaNaoAderente;

    public SomaAderencias(Long somaAderente, Long somaNaoAderente) {
        this.somaAderente = somaAderente;
        this.somaNaoAderente = somaNaoAderente;
    }

    public Long getSomaAderente() {
        return somaAderente;
    }

    public Long getSomaNaoAderente() {
        return somaNaoAderente;
    }
}

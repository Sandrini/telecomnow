package br.com.telecomnow.model;

/**
 * Created by Leonardo on 25/10/2016.
 */
public class Resposta {

    private Pergunta pergunta;
    private Long contador;
    private String regiao;

    public Resposta(Pergunta pergunta, Long contador, String regiao) {
        this.pergunta = pergunta;
        this.contador = contador;
        this.regiao = regiao;
    }

    public void incrementarContador() {
        contador++;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public Long getContador() {
        return contador;
    }

    public String getRegiao() {
        return regiao;
    }

}

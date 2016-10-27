package br.com.telecomnow.repository;

import java.util.Map;
import java.util.Random;

import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.RegiaoEnum;

class GeradorDeDadosDeComponentesPorRegiao {

    private Map<String, ComponenteRegiao> componentesPorRegiaoMap;

    GeradorDeDadosDeComponentesPorRegiao(Map<String, ComponenteRegiao> componentesPorRegiaoMap) {
        this.componentesPorRegiaoMap = componentesPorRegiaoMap;
    }

    void adicionarComponentesParaTodasAsRegioes() {
        for (PerguntasEnum pergunta : PerguntasEnum.values()) {
            Random randow = new Random();
            for (RegiaoEnum regiaoEnum : RegiaoEnum.values()) {
                adicionarComponenteRegiao(regiaoEnum.name(), pergunta.getIdentificador(), nextRandom(randow), nextRandom(randow));
            }
        }
    }

    private Long nextRandom(Random randow) {
        return Long.valueOf(randow.nextInt(1181795250));
    }

    private void adicionarComponenteRegiao(String regiao, String componete, Long aderente, Long naoAderente) {
        ComponenteRegiao componente = new ComponenteRegiao();
        componente.setComponente(componete);
        componente.setRegiao(regiao);
        componente.setQuatidadeAderente(aderente);
        componente.setQuatidadeNaoAderente(naoAderente);
        componentesPorRegiaoMap.put(componente.gerarChave(), componente);
    }

}

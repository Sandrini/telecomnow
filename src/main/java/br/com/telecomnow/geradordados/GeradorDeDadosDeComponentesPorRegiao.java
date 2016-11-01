package br.com.telecomnow.geradordados;

import java.util.Map;
import java.util.Random;

import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.PerguntasEnum;
import br.com.telecomnow.model.RegiaoEnum;

public class GeradorDeDadosDeComponentesPorRegiao {

    private Map<String, ComponenteRegiao> componentesPorRegiaoMap;

    public GeradorDeDadosDeComponentesPorRegiao(Map<String, ComponenteRegiao> componentesPorRegiaoMap) {
        this.componentesPorRegiaoMap = componentesPorRegiaoMap;
    }

    public void adicionarComponentesParaTodasAsRegioes() {
        for (PerguntasEnum pergunta : PerguntasEnum.values()) {
            Random randow = new Random();
            for (RegiaoEnum regiaoEnum : RegiaoEnum.values()) {
                adicionarComponenteRegiao(regiaoEnum.name(), pergunta.getIdentificador(), nextRandom(randow), nextRandom(randow));
            }
        }
    }

    private Long nextRandom(Random randow) {
        return Long.valueOf(randow.nextInt(10));
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

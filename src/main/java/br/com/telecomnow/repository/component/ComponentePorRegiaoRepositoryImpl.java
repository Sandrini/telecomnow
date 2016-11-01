package br.com.telecomnow.repository.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.telecomnow.geradordados.GeradorDeDadosDeComponentesPorRegiao;
import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.RegiaoEnum;
import br.com.telecomnow.model.SomaAderencias;

@Repository
public class ComponentePorRegiaoRepositoryImpl implements ComponentePorRegiaoRepository {

    private Map<String, ComponenteRegiao> componentesPorRegiaoMap = new HashMap<>();

    public ComponentePorRegiaoRepositoryImpl() {
        new GeradorDeDadosDeComponentesPorRegiao(componentesPorRegiaoMap).adicionarComponentesParaTodasAsRegioes();
    }

    @Override
    public void incrementarComponente(String componente, RegiaoEnum regiao, boolean aderente) {
        String chave = componente + regiao;
        ComponenteRegiao componenteRegiao = componentesPorRegiaoMap.getOrDefault(chave, criarComponente(componente, regiao, aderente));
        componentesPorRegiaoMap.put(chave, componenteRegiao);
        componenteRegiao.setQuatidadeAderente(aderente ? componenteRegiao.getQuatidadeAderente()+1 : componenteRegiao.getQuatidadeAderente());
        componenteRegiao.setQuatidadeNaoAderente(!aderente ? componenteRegiao.getQuatidadeNaoAderente()+1 : componenteRegiao.getQuatidadeNaoAderente());
    }

    private ComponenteRegiao criarComponente(String componente, RegiaoEnum regiao, boolean aderente) {
        ComponenteRegiao componenteRegiao = new ComponenteRegiao();
        componenteRegiao.setComponente(componente);
        componenteRegiao.setRegiao(regiao.name());
        componenteRegiao.setQuatidadeAderente(aderente ? 1L : 0L);
        componenteRegiao.setQuatidadeNaoAderente(!aderente ? 1L : 0L);
        return componenteRegiao;
    }

    @Override
    public Collection<ComponenteRegiao> buscarRegioesPorComponente(String componente) {
        Collection<ComponenteRegiao> regioesComponente =
                componentesPorRegiaoMap.values().stream().filter(componenteRegiao -> componenteRegiao.getComponente().equals(componente)).collect(Collectors.toCollection(ArrayList::new));
        return regioesComponente;
    }

    @Override
    public SomaAderencias somarAderencias(String componente) {
        Long somaAderencia = Long.valueOf(0);
        Long somaNaoAderencia = Long.valueOf(0);
        for (ComponenteRegiao componenteRegiao : componentesPorRegiaoMap.values()) {
            if (componenteRegiao.getComponente().equals(componente)) {
                somaAderencia+=componenteRegiao.getQuatidadeAderente();
                somaNaoAderencia+=componenteRegiao.getQuatidadeNaoAderente();
            }
        }
        return new SomaAderencias(somaAderencia, somaNaoAderencia);
    }
}

package br.com.telecomnow.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.ComponenteRegiao;

/**
 * Created by Leonardo on 25/10/2016.
 */
@Repository
public class ComponentePorRegiaoRepositoryImpl implements ComponentePorRegiaoRepository {

    private Map<String, ComponenteRegiao> componentesPorRegiaoMap = new HashMap<>();

    @Autowired
    public ComponentePorRegiaoRepositoryImpl(Perguntas perguntas) {
        new GeradorDeDadosDeComponentesPorRegiao(componentesPorRegiaoMap).adicionarComponentesParaTodasAsRegioes();
    }

    @Override
    public void incrementarComponente(String componente, String regiao, boolean aderente) {
        String chave = componente + regiao;
        ComponenteRegiao componenteRegiao = componentesPorRegiaoMap.get(chave);
        if (componenteRegiao == null) {
            componenteRegiao = new ComponenteRegiao();
            componenteRegiao.setComponente(componente);
            componenteRegiao.setRegiao(regiao);
            componenteRegiao.setQuatidadeAderente(aderente ? 1L : 0L);
            componenteRegiao.setQuatidadeNaoAderente(!aderente ? 1L : 0L);
            componentesPorRegiaoMap.put(chave, componenteRegiao);
        }
    }

    @Override
    public Collection<ComponenteRegiao> buscarRegioesPorComponente(String componente) {
        Collection<ComponenteRegiao> regioesComponente =
                componentesPorRegiaoMap.values().stream().filter(componenteRegiao -> componenteRegiao.getComponente().equals(componente)).collect(Collectors.toCollection(ArrayList::new));
        return regioesComponente;
    }

    @Override
    public Long somarAderencia(String componente) {
        Long soma = Long.valueOf(0);
        for (ComponenteRegiao componenteRegiao : componentesPorRegiaoMap.values()) {
            if (componenteRegiao.getComponente().equals(componente)) {
                soma+=componenteRegiao.getQuatidadeAderente();
            }
        }
        return soma;
    }
}

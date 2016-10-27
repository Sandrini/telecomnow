package br.com.telecomnow.repository.component;

import br.com.telecomnow.geradordados.GeradorDeDadosDeComponentesPorRegiao;
import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.SomaAderencias;
import br.com.telecomnow.repository.questionario.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ComponentePorRegiaoRepositoryImpl implements ComponentePorRegiaoRepository {

    private Map<String, ComponenteRegiao> componentesPorRegiaoMap = new HashMap<>();

    @Autowired
    public ComponentePorRegiaoRepositoryImpl(QuestionarioRepository perguntas) {
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

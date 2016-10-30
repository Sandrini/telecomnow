package br.com.telecomnow.repository.component;

import java.util.Collection;

import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.RegiaoEnum;
import br.com.telecomnow.model.SomaAderencias;

public interface ComponentePorRegiaoRepository {

	void incrementarComponente(String componente, RegiaoEnum regiao, boolean aderente);

    Collection<ComponenteRegiao> buscarRegioesPorComponente(String componente);

    SomaAderencias somarAderencias(String componente);
}

package br.com.telecomnow.repository.component;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.model.SomaAderencias;

import java.util.Collection;

/**
 * Created by Leonardo on 25/10/2016.
 */
public interface ComponentePorRegiaoRepository {

	void incrementarComponente(String componente, String regiao, boolean aderente);

    Collection<ComponenteRegiao> buscarRegioesPorComponente(String componente);

    SomaAderencias somarAderencias(String componente);
}

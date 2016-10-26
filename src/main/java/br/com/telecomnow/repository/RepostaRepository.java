package br.com.telecomnow.repository;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.Resposta;

import java.util.Collection;

/**
 * Created by Leonardo on 25/10/2016.
 */
public interface RepostaRepository {
    Collection<Resposta> buscarRespostaPorPergunta(Pergunta pergunta);
}

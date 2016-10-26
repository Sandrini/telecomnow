package br.com.telecomnow.repository;

import br.com.telecomnow.model.Pergunta;

import java.util.Collection;

public interface Perguntas {

	Collection<Pergunta> buscarTodasAsPerguntas();

	Pergunta buscarPergunta(String identificador);

}

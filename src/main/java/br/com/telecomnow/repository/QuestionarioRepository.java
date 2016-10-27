package br.com.telecomnow.repository;

import java.util.Collection;

import br.com.telecomnow.model.Pergunta;

public interface QuestionarioRepository {

	Collection<Pergunta> buscarTodasAsPerguntas();

	Pergunta buscarPergunta(String identificador);

	void armazenarRespostaParaPergunta(String resposta, Pergunta pergunta);

	String buscarImagemDoProjeto();

}

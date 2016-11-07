package br.com.telecomnow.repository.questionario;

import java.util.Collection;

import br.com.telecomnow.model.Detalhamento;
import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.RegiaoEnum;

public interface QuestionarioRepository {

	Collection<Pergunta> buscarTodasAsPerguntas();

	Pergunta buscarPergunta(String identificador);

	Pergunta armazenarRespostaParaPerguntaERetornarProximaPerguntaSeExistir(String resposta, Pergunta pergunta);

	String buscarImagemDoProjeto();

	void definirRegiao(RegiaoEnum regiao);

    String buscarChaveProjeto();

	Collection<Detalhamento> buscarDetalhamentoDoProjeto();
}

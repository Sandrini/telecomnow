package br.com.telecomnow.repository.questionario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.telecomnow.model.ImagensDosProjetos;
import br.com.telecomnow.model.PerguntasEnum;
import br.com.telecomnow.repository.component.ComponentePorRegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.Pergunta;

@Repository
public class QuestionarioEmMemoria implements QuestionarioRepository {

	@Autowired
	private ComponentePorRegiaoRepository repostaRepository;

	private Map<String, Pergunta> perguntasPorIdentificador;

	private StringBuffer respostasBuffer;

	private String regiao;

	public QuestionarioEmMemoria() {
		regiao = "RS";
		respostasBuffer = new StringBuffer();
		perguntasPorIdentificador = new HashMap<>();

		for (PerguntasEnum perguntaEnum : PerguntasEnum.values()) {
			perguntasPorIdentificador.put(perguntaEnum.getIdentificador(), 
					new Pergunta(
							perguntaEnum.getIdentificador(),
							perguntaEnum.getProxima(), 
							perguntaEnum.getMensagem()
							));
		}
	}

	@Override
	public Collection<Pergunta> buscarTodasAsPerguntas() {
		return perguntasPorIdentificador.values();
	}

	@Override
	public Pergunta buscarPergunta(String identificador) {
		return perguntasPorIdentificador.get(identificador);
	}

	@Override
	public void armazenarRespostaParaPergunta(String resposta, Pergunta pergunta) {
		boolean aderente = "sim".equals(resposta);
		if (aderente) {
			respostasBuffer
				.append(pergunta.getIdentificador())
				.append("+");
		}
		repostaRepository.incrementarComponente(pergunta.getIdentificador(), regiao, aderente);
	}

	@Override
	public String buscarImagemDoProjeto() {
		String identificador = respostasBuffer.toString();
		return ImagensDosProjetos.paraIdentificador(identificador).getPaths();
	}

}

package br.com.telecomnow.repository.questionario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.telecomnow.model.ImagensDosProjetos;
import br.com.telecomnow.model.PerguntasEnum;
import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.Pergunta;

@Repository
public class QuestionarioEmMemoria implements QuestionarioRepository {

	private Map<String, Pergunta> perguntasPorIdentificador;

	private StringBuffer respostasBuffer;
	
	public QuestionarioEmMemoria() {
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
		if ("sim".equals(resposta)) {
			respostasBuffer
				.append(pergunta.getIdentificador())
				.append("+");
		}
	}

	@Override
	public String buscarImagemDoProjeto() {
		String identificador = respostasBuffer.toString();
		return ImagensDosProjetos.paraIdentificador(identificador).getPaths();
	}

}

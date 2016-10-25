package br.com.telecomnow.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.Pergunta;

@Repository
public class PerguntasEmMemoria implements Perguntas {

	private Map<String, Pergunta> perguntasPorIdentificador;

	public PerguntasEmMemoria() {
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
	public Pergunta buscarPergunta(String identificador) {
		return perguntasPorIdentificador.get(identificador);
	}

}

package br.com.telecomnow.repository.questionario;

import static br.com.telecomnow.model.PerguntasEnum.CELULAR;
import static br.com.telecomnow.model.PerguntasEnum.TELEINTEGRACAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.telecomnow.model.ImagensDosProjetos;
import br.com.telecomnow.model.PerguntasEnum;
import br.com.telecomnow.model.RegiaoEnum;
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

	private RegiaoEnum regiao;

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
	public void definirRegiao(RegiaoEnum regiao) {
		this.regiao = regiao;
	}

	@Override
	public Pergunta armazenarRespostaParaPerguntaERetornarProximaPerguntaSeExistir(String resposta, Pergunta pergunta) {
		boolean aderente = "sim".equals(resposta);
		repostaRepository.incrementarComponente(pergunta.getIdentificador(), regiao, aderente);
		if (aderente) {
			respostasBuffer
				.append(pergunta.getIdentificador())
				.append("+");
		}
		if (!aderente && aPerguntaEhTeleintegracao(pergunta)) {
			return buscarPergunta(CELULAR.getIdentificador());
		} else{
			return buscarPergunta(pergunta.getProxima());
		}
	}

	private boolean aPerguntaEhTeleintegracao(Pergunta pergunta) {
		return TELEINTEGRACAO.getIdentificador().equals(pergunta.getIdentificador());
	}

	@Override
	public String buscarImagemDoProjeto() {
		return ImagensDosProjetos.paraIdentificador(respostasBuffer.toString()).getPath();
	}

}

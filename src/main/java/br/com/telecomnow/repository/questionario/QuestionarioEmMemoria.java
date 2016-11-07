package br.com.telecomnow.repository.questionario;

import static br.com.telecomnow.model.PerguntasEnum.CELULAR;
import static br.com.telecomnow.model.PerguntasEnum.TELEATENDIMENTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.Detalhamento;
import br.com.telecomnow.model.ImagensDosProjetos;
import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.PerguntasEnum;
import br.com.telecomnow.model.RegiaoEnum;
import br.com.telecomnow.repository.component.ComponentePorRegiaoRepository;

@Repository
public class QuestionarioEmMemoria implements QuestionarioRepository {

	@Autowired
	private ComponentePorRegiaoRepository repostaRepository;

	private Map<String, Pergunta> perguntasPorIdentificador;

	private StringBuffer respostasBuffer;

	private Collection<Detalhamento> detalhesProjeto;

	private RegiaoEnum regiao;

	public QuestionarioEmMemoria() {
		inicializarBuffersDeSessao();

		perguntasPorIdentificador = new HashMap<>();

		for (PerguntasEnum perguntaEnum : PerguntasEnum.values()) {
			perguntasPorIdentificador.put(perguntaEnum.getIdentificador(), 
					new Pergunta(
							perguntaEnum.getIdentificador(),
							perguntaEnum.getProxima(), 
							perguntaEnum.getMensagem(),
							perguntaEnum.getDetalhamento()
							));
		}
	}

	private void inicializarBuffersDeSessao() {
		respostasBuffer = new StringBuffer();
		detalhesProjeto = new ArrayList<>();
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
		inicializarBuffersDeSessao();
		this.regiao = regiao;
	}

	@Override
	public String buscarChaveProjeto() {
		return respostasBuffer.toString();
	}

	@Override
	public Collection<Detalhamento> buscarDetalhamentoDoProjeto() {
		return detalhesProjeto;
	}

	@Override
	public Pergunta armazenarRespostaParaPerguntaERetornarProximaPerguntaSeExistir(String resposta, Pergunta pergunta) {
		boolean aderente = "sim".equals(resposta);
		repostaRepository.incrementarComponente(pergunta.getIdentificador(), regiao, aderente);
		if (aderente) {
			respostasBuffer
				.append(pergunta.getIdentificador())
				.append("+");
			detalhesProjeto.add(pergunta.getDetalhamento());
		}
		if (!aderente && aPerguntaEhTeleatendimento(pergunta)) {
			return buscarPergunta(CELULAR.getIdentificador());
		} else{
			return buscarPergunta(pergunta.getProxima());
		}
	}

	private boolean aPerguntaEhTeleatendimento(Pergunta pergunta) {
		return TELEATENDIMENTO.getIdentificador().equals(pergunta.getIdentificador());
	}

	@Override
	public String buscarImagemDoProjeto() {
		return ImagensDosProjetos.paraIdentificador(respostasBuffer.toString()).getPath();
	}

}

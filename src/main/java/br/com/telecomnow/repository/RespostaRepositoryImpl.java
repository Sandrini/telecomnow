package br.com.telecomnow.repository;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Leonardo on 25/10/2016.
 */
@Repository
public class RespostaRepositoryImpl implements RepostaRepository {

    private Map<Pergunta, Collection<Resposta>> perguntasPorIdentificador;

    @Autowired
    public RespostaRepositoryImpl(Perguntas perguntas) {
        this.perguntasPorIdentificador = new HashMap<>();
        for (Pergunta pergunta : perguntas.buscarTodasAsPerguntas()) {
            List<Resposta>  respostas = Arrays.asList(
                    new Resposta(pergunta, 500L, "RS"),
                    new Resposta(pergunta, 600L,"SP"),
                    new Resposta(pergunta, 1500L,"RJ"),
                    new Resposta(pergunta, 350L,"MG"),
                    new Resposta(pergunta, 270L, "SC"));
            perguntasPorIdentificador.put(pergunta, respostas);
        }
    }


    @Override
    public Collection<Resposta> buscarRespostaPorPergunta(Pergunta pergunta) {
        return  perguntasPorIdentificador.get(pergunta);
    }
}

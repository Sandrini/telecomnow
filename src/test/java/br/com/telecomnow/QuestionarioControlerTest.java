package br.com.telecomnow;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.telecomnow.repository.questionario.QuestionarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.telecomnow.controler.QuestionarioController;
import br.com.telecomnow.model.Detalhamento;
import br.com.telecomnow.model.Pergunta;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionarioController.class)
public class QuestionarioControlerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionarioRepository perguntas;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testaGetParaPrimeiraPergunta() throws Exception {
        given(perguntas.buscarPergunta("UNIDADE"))
                .willReturn(new Pergunta("UNIDADE", "PROXIMA-PERGUNTA-IDENTIFICADOR", "La Pergunta?", new Detalhamento("componente", "lo detalhamento")));

        mvc.perform(get("/questionario").accept(TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("La Pergunta?")))
                .andExpect(content().string(containsString("id=\"UNIDADE\"")))
                .andExpect(content().string(containsString("next=\"PROXIMA-PERGUNTA-IDENTIFICADOR\"")))
        ;
    }

}

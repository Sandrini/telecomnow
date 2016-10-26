package br.com.telecomnow.controler;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.Resposta;
import br.com.telecomnow.repository.Perguntas;
import br.com.telecomnow.repository.RepostaRepository;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class GraficoController {

    @Autowired
    private RepostaRepository repostaRepository;

    @Autowired
    private Perguntas perguntas;


    @RequestMapping(value = "/grafico")
    public String grafico(Model model) {

       List<String> graficos = new ArrayList<>();
        for (Pergunta pergunta : perguntas.buscarTodasAsPerguntas()) {
            List<Slice> fatias = new ArrayList<>();
            for (Resposta resposta : repostaRepository.buscarRespostaPorPergunta(pergunta)) {
                fatias.add(Slice.newSlice(resposta.getContador().intValue(), null, resposta.getRegiao(), pergunta.getMensagem()));
            }
            PieChart pieChart = GCharts.newPieChart(fatias);
            pieChart.setTitle("Respostas por região", Color.BLACK, 18);
            pieChart.setSize(420, 180);
            pieChart.setThreeD(false);
            graficos.add(pieChart.toURLString());
        }
        model.addAttribute("graficosUrls", graficos);
        return "grafico";
    }
}

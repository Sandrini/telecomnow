package br.com.telecomnow.controler;

import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.repository.Perguntas;
import br.com.telecomnow.repository.ComponentePorRegiaoRepository;
import br.com.telecomnow.repository.PerguntasEnum;
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
public class GraficoAderenciaRegiaoController {

    @Autowired
    private ComponentePorRegiaoRepository repostaRepository;

    @Autowired
    private Perguntas perguntas;


    @RequestMapping(value = "/graficoAderenciaRegiao")
    public String grafico(Model model) {
        List<String> graficos = new ArrayList<>();
        graficos.add(gerarGraficoPizzaAderenciaPorRegiao(PerguntasEnum.CHAT.getIdentificador()).toURLString());
        graficos.add(gerarGraficoPizzaAderenciaPorRegiao(PerguntasEnum.GRAVACAO.getIdentificador()).toURLString());
        graficos.add(gerarGraficoPizzaAderenciaPorRegiao(PerguntasEnum.CELULAR.getIdentificador()).toURLString());
        model.addAttribute("graficosUrls", graficos);
        return "graficoAderenciaRegiao";
    }

    private PieChart gerarGraficoPizzaAderenciaPorRegiao(String componente) {
        Collection<ComponenteRegiao> regioesDoComponente = repostaRepository.buscarRegioesPorComponente(componente);
        List<Slice> fatias = new ArrayList<>();
        for (ComponenteRegiao componenteRegiao : regioesDoComponente) {
            fatias.add(Slice.newSlice(componenteRegiao.getQuatidadeAderente().intValue(),  componenteRegiao.getRegiao()));
        }
        PieChart pieChart = GCharts.newPieChart(fatias);
        pieChart.setTitle(String.format("Aderencia de %s por região", componente), Color.BLACK, 24);
        pieChart.setSize(720, 380);
        pieChart.setThreeD(false);
        return pieChart;
    }
}

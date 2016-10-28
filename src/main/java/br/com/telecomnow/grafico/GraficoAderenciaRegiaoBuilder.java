package br.com.telecomnow.grafico;

import br.com.telecomnow.model.ComponenteRegiao;
import br.com.telecomnow.repository.component.ComponentePorRegiaoRepository;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GraficoAderenciaRegiaoBuilder {

    @Autowired
    private ComponentePorRegiaoRepository repostaRepository;

    public String build(String componente) {
        Collection<ComponenteRegiao> regioesDoComponente = repostaRepository.buscarRegioesPorComponente(componente);
        List<Slice> fatias = new ArrayList<>();
        for (ComponenteRegiao componenteRegiao : regioesDoComponente) {
            fatias.add(Slice.newSlice(componenteRegiao.getQuatidadeAderente().intValue(),  componenteRegiao.getRegiao()));
        }
        PieChart pieChart = GCharts.newPieChart(fatias);
        pieChart.setTitle(String.format("Aderencia de %s por região", componente), Color.BLACK, 24);
        pieChart.setSize(720, 380);
        pieChart.setThreeD(false);
        return pieChart.toURLString();
    }
}

package br.com.telecomnow.grafico;

import br.com.telecomnow.model.PerguntasEnum;
import br.com.telecomnow.model.SomaAderencias;
import br.com.telecomnow.repository.component.ComponentePorRegiaoRepository;
import com.googlecode.charts4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraficoAderenciaTotalBuilder {

    @Autowired
    private ComponentePorRegiaoRepository repostaRepository;

    public String build() {

        List<String> nomesDeComponentes = new ArrayList<>();
        List<Integer> somatorioComAderencia = new ArrayList<>();
        List<Integer> somatorioSemAderencia = new ArrayList<>();

        int maxSoma=0;
        for (PerguntasEnum perguntasEnum : PerguntasEnum.values()) {
            nomesDeComponentes.add(perguntasEnum.getIdentificador());
            SomaAderencias aderencias = repostaRepository.somarAderencias(perguntasEnum.getIdentificador());
            somatorioComAderencia.add(aderencias.getSomaAderente().intValue());
            somatorioSemAderencia.add(aderencias.getSomaNaoAderente().intValue());
            maxSoma =  aderencias.getSomaTotal() > maxSoma ? aderencias.getSomaTotal().intValue() : maxSoma;
        }
        BarChartPlot comAderencia= Plots.newBarChartPlot(Data.newData(somatorioSemAderencia), Color.newColor("19194d"),"COM ADERENCIA");
        BarChartPlot semAderencia=Plots.newBarChartPlot(Data.newData(somatorioComAderencia),Color.newColor("8c8cd9"),"SEM ADERENCIA");
        BarChart chart=GCharts.newBarChart(comAderencia, semAderencia);

        //definindo o estilo dos labels
        AxisStyle axisStyle=AxisStyle.newAxisStyle(Color.BLACK,13,AxisTextAlignment.CENTER);

        //Adicionado labels no vetor de componetes
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(nomesDeComponentes));

        //Adicionado labels no vetor de solicitacoes
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0,maxSoma));

        //definindo o vetor Y
        AxisLabels solicitacoes=AxisLabelsFactory.newAxisLabels("Solicitações",50.0);
        solicitacoes.setAxisStyle(axisStyle);
        chart.addYAxisLabels(solicitacoes);

        //definindo o vetor X
        AxisLabels componentes=AxisLabelsFactory.newAxisLabels("Componentes",50.0);
        componentes.setAxisStyle(axisStyle);
        chart.addXAxisLabels(componentes);

        chart.setSize(950,250);
        chart.setBarWidth(100);
        chart.setSpaceWithinGroupsOfBars(20);
        chart.setDataStacked(true);
        chart.setTitle("Aderencia total de componentes",Color.BLACK,24);
        chart.setGrid(100,10,3,2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.ALICEBLUE));
        LinearGradientFill fill=Fills.newLinearGradientFill(0,Color.LAVENDER,100);
        fill.addColorAndOffset(Color.WHITE,0);
        chart.setAreaFill(fill);
        return chart.toURLString();
    }
}

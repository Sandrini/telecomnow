package br.com.telecomnow.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.googlecode.charts4j.*;

import br.com.telecomnow.repository.ComponentePorRegiaoRepository;
import br.com.telecomnow.repository.PerguntasEnum;

@Controller
public class GraficoDemandaComponentesController {

    @Autowired
    private ComponentePorRegiaoRepository repostaRepository;


    @RequestMapping(value = "/graficoDemanda")
    public String grafico(Model model) {
        List<String> graficos = new ArrayList<>();
        graficos.add(gera());
        model.addAttribute("graficosUrls", graficos);
        return "graficoDemandaComponentes";
    }

    private String gera() {
        BarChartPlot team1=Plots.newBarChartPlot(Data.newData(25,43,12,30),Color.RED,"SEM ADERENCIA");
        BarChartPlot team2=Plots.newBarChartPlot(Data.newData(8,35,11,5),Color.GREEN,"COM ADERENCIA");
        BarChart chart=GCharts.newBarChart(team1,team2);
        AxisStyle axisStyle=AxisStyle.newAxisStyle(Color.BLACK,13,AxisTextAlignment.CENTER);
        AxisLabels score=AxisLabelsFactory.newAxisLabels("Solicitações",50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year=AxisLabelsFactory.newAxisLabels("Componentes",50.0);
        year.setAxisStyle(axisStyle);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("CHAT","CELULAR","GRAVACAO","TELEINTEGRACAO"));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0,100));
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);
        chart.setSize(700,350);
        chart.setBarWidth(100);
        chart.setSpaceWithinGroupsOfBars(20);
        chart.setDataStacked(true);
        chart.setTitle("Demandas de componentes",Color.BLACK,16);
        chart.setGrid(100,10,3,2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.ALICEBLUE));
        LinearGradientFill fill=Fills.newLinearGradientFill(0,Color.LAVENDER,100);
        fill.addColorAndOffset(Color.WHITE,0);
        chart.setAreaFill(fill);
        return chart.toURLString();
    }

    private String gerarGraficoDemanda() {
        List<BarChartPlot> barras = new ArrayList<>();
        Long maxPlusOne = 0L;
        List<String> countLabels = new ArrayList<String>();
        for (PerguntasEnum perguntasEnum : PerguntasEnum.values()) {
            countLabels.add(perguntasEnum.getIdentificador());
            Long soma = repostaRepository.somarAderencia(perguntasEnum.getIdentificador());
            maxPlusOne = soma > maxPlusOne ?  soma: maxPlusOne;
            BarChartPlot barra = Plots.newBarChartPlot( Data.newData(soma),  Color.DARKGRAY, perguntasEnum.getIdentificador());
            barras.add(barra);
        }
        BarChart chart = GCharts.newBarChart(barras);
        chart.setTitle("Demanda de componentes", Color.BLACK, 24);

        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, maxPlusOne));
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(countLabels));
        chart.setSize(900, 320);
        chart.setBarWidth(BarChart.AUTO_RESIZE);
        chart.setSpaceBetweenGroupsOfBars(1);
        return chart.toURLString();
    }
}

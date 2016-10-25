package br.com.telecomnow.controler;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraficoController {

    @RequestMapping(value = "/grafico")
    public String grafico(Model model) {
        Slice s1 = Slice.newSlice(15, Color.newColor("CACACA"), "RS", "Rio Grande do Sul");
        Slice s2 = Slice.newSlice(50, Color.newColor("DF7417"), "RJ", "Rio de Janeiro");
        Slice s3 = Slice.newSlice(25, Color.newColor("951800"), "MG", "Minas Gerais");
        Slice s4 = Slice.newSlice(10, Color.newColor("01A1DB"), "SP", "São Paulo");

        PieChart pieChart = GCharts.newPieChart(s1, s2, s3, s4);
        pieChart.setTitle("Regiões com maior demanda de Aplicativos", Color.BLACK, 24);
        pieChart.setSize(720, 360);
        pieChart.setThreeD(false);

        model.addAttribute("pieUrl", pieChart.toURLString());

        return "grafico";
    }
}

package br.com.telecomnow.controler;

import java.util.ArrayList;
import java.util.List;

import br.com.telecomnow.grafico.GraficoAderenciaTotalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraficoAderenciasTotalController {

    @Autowired
    private GraficoAderenciaTotalBuilder construtorGraficoDemanda;

    @RequestMapping(value = "/graficoaderenciatotal")
    public String grafico(Model model) {
        List<String> graficos = new ArrayList<>();
        String urlImgGrafico = construtorGraficoDemanda.build();
        graficos.add(urlImgGrafico);
        model.addAttribute("graficosUrls", graficos);
        return "graficoDemandaComponentes";
    }


}

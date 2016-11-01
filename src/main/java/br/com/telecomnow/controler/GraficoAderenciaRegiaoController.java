package br.com.telecomnow.controler;

import br.com.telecomnow.grafico.GraficoAderenciaRegiaoBuilder;
import br.com.telecomnow.model.PerguntasEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GraficoAderenciaRegiaoController {

    @Autowired
    private GraficoAderenciaRegiaoBuilder graficoAderenciaRegiaoBuilder;

    @RequestMapping(value = "/graficoaderenciaregiao")
    public String grafico(Model model) {
        List<String> graficos = new ArrayList<>();
        for (PerguntasEnum pergunta : PerguntasEnum.values()) {
            graficos.add(graficoAderenciaRegiaoBuilder.build(pergunta.getIdentificador()));
        }
        model.addAttribute("graficosUrls", graficos);
        return "graficoAderenciaRegiao";
    }


}

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

    @RequestMapping(value = "/graficoAderenciaRegiao")
    public String grafico(Model model) {
        List<String> graficos = new ArrayList<>();
        graficos.add(graficoAderenciaRegiaoBuilder.build(PerguntasEnum.CHAT.getIdentificador()));
        graficos.add(graficoAderenciaRegiaoBuilder.build(PerguntasEnum.GRAVACAO.getIdentificador()));
        graficos.add(graficoAderenciaRegiaoBuilder.build(PerguntasEnum.CELULAR.getIdentificador()));
        model.addAttribute("graficosUrls", graficos);
        return "graficoAderenciaRegiao";
    }


}

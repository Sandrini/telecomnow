package br.com.telecomnow.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.repository.Perguntas;

@Controller
public class QuestionarioController {

	@Autowired
	private Perguntas perguntas;
	
    @RequestMapping("/questionario")
    public String getPergunta(
    		@RequestParam(value="pergunta", required=false, defaultValue="UNIDADE") String identificador, 
    		Model model
    		) {
    	model.addAttribute("pergunta", perguntas.buscarPergunta(identificador));
        return "questionario";
    }
    
    @RequestMapping(value = "/questionario", method={RequestMethod.POST}, params="sim")
    public String responderSim(@ModelAttribute Pergunta pergunta, Model model) {
    	model.addAttribute("pergunta", perguntas.buscarPergunta(pergunta.getProxima()));
    	return "questionario";
    }

    @RequestMapping(value = "/questionario", method={RequestMethod.POST}, params="nao")
    public String responderNao(@ModelAttribute Pergunta pergunta, Model model) {
    	model.addAttribute("pergunta", perguntas.buscarPergunta(pergunta.getProxima()));
    	return "questionario";
    }

}

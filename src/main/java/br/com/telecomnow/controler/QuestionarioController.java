package br.com.telecomnow.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.repository.QuestionarioRepository;

@Controller
public class QuestionarioController {

	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	private Pergunta pergunta;
	
    @GetMapping("/questionario")
    public String iniciarQuestionario(Model model) {
    	pergunta = questionarioRepository.buscarPergunta("UNIDADE");
    	model.addAttribute("pergunta", pergunta);
        return "questionario";
    }
    
    @PostMapping("/questionario")
    public String responder(@RequestParam String resposta, Model model) {
    	questionarioRepository.armazenarRespostaParaPergunta(resposta, pergunta);
    	if(pergunta.possuiProximaPergunta()){
    		pergunta = questionarioRepository.buscarPergunta(pergunta.getProxima());
    		model.addAttribute("pergunta", pergunta);
    		return "questionario";
    	} else {
    		model.addAttribute("imagemPath", questionarioRepository.buscarImagemDoProjeto());
    		return "projeto";
    	}
    }

}

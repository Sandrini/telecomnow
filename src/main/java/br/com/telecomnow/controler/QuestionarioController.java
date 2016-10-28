package br.com.telecomnow.controler;

import br.com.telecomnow.repository.component.ComponentePorRegiaoRepository;
import br.com.telecomnow.repository.empresavendedora.EmpresaVendedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.repository.questionario.QuestionarioRepository;

@Controller
public class QuestionarioController {

	@Autowired
	private QuestionarioRepository questionarioRepository;

	@Autowired
	private EmpresaVendedoraRepository empresaVendedoraRepository;



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
			model.addAttribute("empresasVendedoras", empresaVendedoraRepository.sortearEmpresas());
    		model.addAttribute("imagemPath", questionarioRepository.buscarImagemDoProjeto());
    		return "projeto";
    	}
    }

}

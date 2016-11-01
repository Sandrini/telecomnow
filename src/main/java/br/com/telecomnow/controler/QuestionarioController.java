package br.com.telecomnow.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.telecomnow.model.Pergunta;
import br.com.telecomnow.model.RegiaoEnum;
import br.com.telecomnow.repository.empresavendedora.EmpresaVendedoraRepository;
import br.com.telecomnow.repository.questionario.QuestionarioRepository;

@Controller
public class QuestionarioController {

	@Autowired
	private QuestionarioRepository questionarioRepository;

	@Autowired
	private EmpresaVendedoraRepository empresaVendedoraRepository;

	private Pergunta pergunta;
	
	@GetMapping({"regiao", "pergunta"})
	public String atualizarEmOutrasPaginas() {
		return "redirect:questionario";
	}
	
    @GetMapping("/questionario")
    public String iniciarQuestionario(Model model) {
    	model.addAttribute("regioes", RegiaoEnum.values());
    	model.addAttribute("pergunta", "Em qual região sua empresa se encontra?");
        return "regiao";
    }
    
    @PostMapping(path = "/regiao")
    public String responder(@RequestParam RegiaoEnum regiao, Model model) {
    	questionarioRepository.definirRegiao(regiao);
    	pergunta = questionarioRepository.buscarPergunta("UNIDADE");
		model.addAttribute("pergunta", pergunta);
    	return "pergunta";
    }

    @PostMapping("/pergunta")
    public String responder(@RequestParam String resposta, Model model) {
    	pergunta = questionarioRepository.armazenarRespostaParaPerguntaERetornarProximaPerguntaSeExistir(resposta, pergunta);
		if(pergunta != null){
    		model.addAttribute("pergunta", pergunta);
    		return "pergunta";
    	} else {
			model.addAttribute("empresasVendedoras", empresaVendedoraRepository.sortearEmpresas());
			model.addAttribute("imagemPath", questionarioRepository.buscarImagemDoProjeto());
			model.addAttribute("chaveProjeto", questionarioRepository.buscarChaveProjeto());
			model.addAttribute("detalhesProjeto", questionarioRepository.buscarDetalhamentoDoProjeto());
    		return "projeto";
    	}
    }

}
	
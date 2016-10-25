/**
 * Função para processamento da lógica das perguntas. 
 * Esta função é acionada quando o botão do SIM o NÃO for clicado.
 * @param btn - Botão clicado (SIM/NAO).
 */	
 
function next(btn){

	initializeControlVariables();

	// Busca a questao atual
	curret_question = localStorage.current_question;
	current_question_div = document.getElementById(curret_question);
	
	// Controla o fluxo de proxima pergunta para o TELEATENDIMENTO
	btn_clicked = document.getElementById(btn.id);
	if (curret_question === "TELEATENDIMENTO" && btn_clicked.id === "nao") {
		current_question_div.setAttribute('next', "CELULAR");
	}
	
	// Busca a div da proxima pergunta
	next_question = current_question_div.getAttribute('next');
	
	// Esconde a questao atual
	fadeOut(curret_question, 0, next_question);
	
	// Exibe a próxima pergunta
	fadeIn(next_question, 0);
	
	// armazena a chave da pergunta atual com a sua resposta
	localStorage.chave=localStorage.chave+curret_question+btn_clicked.id
	
	// Verifica se o próximo elemento ainda é pregunta
	if(next_question === "RESULTADO"){
		
		// Esconde os botoes de perguntas
		hideButtons();
		
		// Mostra a chave do projeto
		//document.getElementById(next_question).innerHTML = localStorage.chave;
		
		// Mostra a imagem do projeto baseado na chave
		projeto = document.getElementById(localStorage.chave);
		if (projeto != null) {
			fadeIn(localStorage.chave,0);
			projeto.style.display = "block";
		}

		// Exibe o botão para refazer o questionário
		fadeIn('back', 0);
		document.getElementById('back').style.display = 'block';
		
		// Reinicia variaveis de controle
		localStorage.chave="";
		localStorage.current_question = null;
	} else {
		// Passa para a proxima pergunta
		localStorage.current_question = next_question;
	}
}

function clearControlVariables() {
	localStorage.chave = "";
	localStorage.current_question = "UNIDADE";
}

function initializeControlVariables() {
	postServer() ;
	
	if (localStorage.current_question === "null" || localStorage.current_question === undefined || localStorage.current_question === "UNIDADE") {
		clearControlVariables();
	}
}

function downloadImg(linkElement) {
    var myImage = document.getElementById(localStorage.chave);
    linkElement.href = myImage.src;
}

function hideButtons(){ 
	btn_sim = document.getElementById('sim');
	btn_nao = document.getElementById('nao');
	btn_sim.style.display = 'none';
	btn_nao.style.display = 'none';

}

/**
 * Função para esconder elemento com efeito fade.
 * @param id - ID do elemento a ser escondido.
 * @param val - Valor inicial para opacity, entre 0 e 9.
 */
function fadeOut(id, val, id_next){ if(isNaN(val)){ val = 9;}
	
	document.getElementById(id).style.opacity='0.'+val;
	
	// Para IE
	document.getElementById(id).style.filter='alpha(opacity='+val+'0)';
	
	if(val>0){
		val--;
		setTimeout('fadeOut("'+id+'",'+val+','+id_next+')',90);
	}else{
		document.getElementById(id).style.display = "none";
		document.getElementById(id_next).style.display = "block";
		return;
	}
}

/**
 * Função para exibir elemento com efeito fade.
 * @param id - ID do elemento a ser exibido.
 * @param val - Valor inicial para opacity, entre 0 e 9.
 */
function fadeIn(id, val){
	
	if(isNaN(val)){ val = 0;}
	
	document.getElementById(id).style.opacity='0.'+val;
	
	// Para IE
	document.getElementById(id).style.filter='alpha(opacity='+val+'0)';

	if(val<9){
		val++; 
		setTimeout('fadeIn("'+id+'",'+val+')',180);
	}else{
		return;
	}
}
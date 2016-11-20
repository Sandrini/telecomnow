package br.com.telecomnow.model;

public enum PerguntasEnum {

	UNIDADE("Sua empresa possui, além da matriz, mais unidades (filiais)?",
			"TELEATENDIMENTO",
			"PABX é a central telefônica analógica propriamente dita. É o conceito de ramal ramal. Tarifador Centralizado computa os custos de ligação de todos os ramais. Consigo saber quanto o ramal de determinado funcionário gastou em ligações, no período de um mês. No projeto acima teremos uma Matriz que se comunicará com as demais Filiais, através do STFC (Serviço Telefônico Fixo Comutado - destinado a comunicação entre pontos fixos)."),
	TELEATENDIMENTO("Há necessidade de inserir solução de teleatendimento (para call center ou sac), em sua empresa",
			"TELEINTEGRACAO",
			"Atendedor Digital é a Ura Simplificada, onde temos uma gravação com a seguinte mensagem: Digite 1 para informações da faculdade, 2  secretaria, 3 financeiro, etc). URA é quando o atendimento efetuado assemelha-se ao da NET. "),
	TELEINTEGRACAO("Deseja integração da solução de teleatendimento com seu sistema de gestão?",
			"CHAT",
			"Tele Integração é integrar a Solução de Tele antendimento com outros softwares que o cliente utiliza na empresa."),
	CHAT("Alem de atendimento via voz, sua demanda necessita de atendimento via CHAT?",
			"GRAVACAO",
			"Contact Center é um centro de ligação mais completo, onde é possível atender o cliente via chat, email e via voz."),
	GRAVACAO("Deseja realizar gravação dos atendimentos?",
			"CELULAR",
			"A gravação da ligação se dá quando o cliente necessita por questões de segurança ou por questões de qualidade."),
	CELULAR("Deseja incluir solução de interface de celular?",
			null,
			"Interface Celular é um hardware, junto à Central Telefônica, que possui vários chips de várias operadoras de telefonia e esse hardware faz consulta portabilidade. Quando um funcionário da empresa efetua uma ligação para um celular, esse equipamento consulta qual a operadora de destino da ligação, após identificada o hardware utiliza o chip correspondente a mesma operadora, efetuando dessa forma uma ligação a custo zero para a empresa."),
	;
	
	private final String mensagem;

	private final String proxima;
	
	private final String identificador;

	private final String detalhamento;

	private PerguntasEnum(String mensagem, String proxima,String detalhamento) {
		this.mensagem = mensagem;
		this.proxima = proxima;
		this.detalhamento = detalhamento;
		this.identificador = this.name();
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getProxima() {
		return proxima;
	}

	public String getIdentificador() {
		return identificador;
	}

	public Detalhamento getDetalhamento() {
		return new Detalhamento(name(), detalhamento);
	}
}

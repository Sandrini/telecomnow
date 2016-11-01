package br.com.telecomnow.model;

public enum PerguntasEnum {

	UNIDADE("Sua empresa possui, além da matriz, mais unidades (filiais)?",
			"TELEATENDIMENTO",
			"UNIDADE: <explicar aqui a sobre o componente>"),
	TELEATENDIMENTO("Há necessidade de inserir solução de teleatendimento (para call center ou sac), em sua empresa",
			"TELEINTEGRACAO",
			"UNIDADE: <explicar aqui a sobre o componente>"),
	TELEINTEGRACAO("Deseja integração da solução de teleatendimento com seu sistema de gestão?",
			"CHAT",
			"TELEINTEGRACAO: <explicar aqui a sobre o componente>"),
	CHAT("Alem de atendimento via voz, sua demanda necessita de atendimento via CHAT?",
			"GRAVACAO",
			"CHAT: <explicar aqui a sobre o componente>"),
	GRAVACAO("Deseja realizar gravação dos atendimentos?",
			"CELULAR",
			"GRAVACAO: <explicar aqui a sobre o componente>"),
	CELULAR("Deseja incluir solução de interface de celular?",
			null,
			"CELULAR: <explicar aqui a sobre o componente>"),
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

	public String getDetalhamento() {
		return detalhamento;
	}
}

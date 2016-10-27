package br.com.telecomnow.repository;

public enum PerguntasEnum {

	UNIDADE("Sua empresa possui, além da matriz, mais unidades (filiais)?", "TELEINTEGRACAO"),
	TELEATENDIMENTO("Há necessidade de inserir solução de teleatendimento (para call center ou sac), em sua empresa", "TELEINTEGRACAO"),
	TELEINTEGRACAO("Deseja integração da solução de teleatendimento com seu sistema de gestão?", "CHAT"),
	CHAT("Alem de atendimento via voz, sua demanda necessita de atendimento via CHAT?", "GRAVACAO"),
	GRAVACAO("Deseja realizar gravação dos atendimentos?", "CELULAR"),
	CELULAR("Deseja incluir solução de interface de celular?", null),
	;
	
	private final String mensagem;

	private final String proxima;
	
	private final String identificador;

	private PerguntasEnum(String mensagem, String proxima) {
		this.mensagem = mensagem;
		this.proxima = proxima;
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
	
}

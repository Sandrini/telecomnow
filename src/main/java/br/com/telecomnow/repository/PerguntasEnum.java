package br.com.telecomnow.repository;

public enum PerguntasEnum {

	UNIDADE("Sua empresa possui, além da matriz, mais unidades (filiais)?", "TELEINTEGRACAO"),
	TELEATENDIMENTO("H&aacute; necessidade de inserir solu&ccedil;&atilde;o de teleatendimento (para call center ou sac), em sua empresa", "TELEINTEGRACAO"),
	TELEINTEGRACAO("Deseja integra&ccedil;&atilde;o da solu&ccedil;&atilde;o de teleatendimento com seu sistema de gest&atilde;o?", "CHAT"),
	CHAT("Alem de atendimento via voz, sua demanda necessita de atendimento via CHAT?", "GRAVACAO"),
	GRAVACAO("Deseja realizar grava&ccedil;&atilde;o dos atendimentos?", "CELULAR"),
	CELULAR("Deseja incluir solu&ccedil;&atilde;o de interface de celular?", "RESULTADO"),
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

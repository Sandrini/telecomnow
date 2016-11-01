package br.com.telecomnow.model;

public class Pergunta {

	private String identificador;

	private String proxima;

	private String mensagem;

	public Pergunta() {
	}

	public Pergunta(String identificador, String proxima, String mensagem) {
		this.identificador = identificador;
		this.proxima = proxima;
		this.mensagem = mensagem;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getProxima() {
		return proxima;
	}

	public void setProxima(String proxima) {
		this.proxima = proxima;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean possuiProximaPergunta() {
		return proxima != null && !proxima.isEmpty();
	}

	@Override
	public String toString() {
		return "Pergunta [" + identificador + "]";
	}	
	
}

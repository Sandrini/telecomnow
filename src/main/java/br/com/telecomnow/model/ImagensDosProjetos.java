package br.com.telecomnow.model;

import static java.util.Arrays.stream;

public enum ImagensDosProjetos {
	Projeto1(""),
	Projeto2("TELEATENDIMENTO+"),
	Projeto3("TELEATENDIMENTO+CHAT+CELULAR+"),
	Projeto4("TELEATENDIMENTO+CELULAR"),
	Projeto5("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+CHAT+GRAVACAO+CELULAR+"),
	Projeto6("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+CHAT+GRAVACAO+"),
	Projeto7("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+CHAT+CELULAR+"),
	Projeto8("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+CHAT+"),
	Projeto9("UNIDADE+CELULAR+"),
	Projeto10("UNIDADE+"),
	Projeto11("UNIDADE+TELEATENDIMENTO+CHAT+"),
	Projeto12("UNIDADE+TELEATENDIMENTO+"),
	Projeto13("UNIDADE+TELEATENDIMENTO+CELULAR+"),
	Projeto14("UNIDADE+TELEATENDIMENTO+CHAT+CELULAR+"),
	Projeto15("UNIDADE+TELEATENDIMENTO+CHAT+GRAVACAO+CELULAR+"),
	Projeto16("UNIDADE+TELEATENDIMENTO+GRAVACAO+CELULAR+"),
	Projeto17("UNIDADE+TELEATENDIMENTO+GRAVACAO+"),
	Projeto18("UNIDADE+TELEATENDIMENTO+CHAT+GRAVACAO+"),
	Projeto19("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+GRAVACAO+CELULAR+"),
	Projeto20("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+GRAVACAO+"),
	Projeto21("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+CELULAR+"),
	Projeto22("UNIDADE+TELEATENDIMENTO+TELEINTEGRACAO+"),
	Projeto23("CELULAR+"),
	Projeto24("TELEATENDIMENTO+CHAT+"),
	Projeto25("TELEATENDIMENTO+CHAT+GRAVACAO+"),
	Projeto26("TELEATENDIMENTO+GRAVACAO+"),
	Projeto27("TELEATENDIMENTO+TELEINTEGRACAO+GRAVACAO+"),
	Projeto28("TELEATENDIMENTO+TELEINTEGRACAO+CHAT+GRAVACAO+"),
	Projeto29("TELEATENDIMENTO+TELEINTEGRACAO+CHAT+GRAVACAO+CELULAR+"),
	Projeto30("TELEATENDIMENTO+TELEINTEGRACAO+GRAVACAO+CELULAR+"),
	Projeto31("TELEATENDIMENTO+TELEINTEGRACAO+CELULAR+"),
	Projeto32("TELEATENDIMENTO+TELEINTEGRACAO+CHAT+CELULAR+"),
	Projeto33("TELEATENDIMENTO+TELEINTEGRACAO+"),
	Projeto34("TELEATENDIMENTO+TELEINTEGRACAO+CHAT+"),
	Projeto35("TELEATENDIMENTO+CHAT+GRAVACAO+CELULAR+"),
	Projeto36("TELEATENDIMENTO+GRAVACAO+CELULAR+"),
	NULL();
	;

	private String identificador;

	private String path;
	
	private ImagensDosProjetos() {
		identificador = "null";
	}
	
	private ImagensDosProjetos(String identificador){
		this.identificador = identificador;
		this.path = "img/"+name()+".jpg";
	}
	
	public static ImagensDosProjetos paraIdentificador(String identificador) {
		return stream(values())
					.filter( t -> t.identificador.equals(identificador))
					.findAny()
					.orElse(NULL);
	}

	public String getPath() {
		return path;
	}

}

package br.com.k19.servlet;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteBean {

	private int numero;
	private String texto;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	// incrementando número
	public void incrementaNumero() {
		this.numero = numero + 1;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto=texto;
	}
	
	// transformando em letras maíusculas
	public String transformaEmCaixaAlta() {
		this.texto = this.texto.toUpperCase();
		return "resposta";
	}

}

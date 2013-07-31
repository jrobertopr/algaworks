package br.com.k19.entidade;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// minha entidade de gerenciamento
@Entity
public class Usuario {
	
	// chave primária gerando valor 
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	// permite armazenar apenas a data 
	@Temporal(TemporalType.DATE)
	private Calendar dataDeCadastro;
	
	// objetos longos para tipo de dados específicos
	@Lob
	private byte[] foto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}

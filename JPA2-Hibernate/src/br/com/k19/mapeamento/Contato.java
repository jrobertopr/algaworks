package br.com.k19.mapeamento;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contato {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	// realizando o mapeamento
	@ElementCollection
	@CollectionTable(
			name="contato",
			joinColumns=@JoinColumn(name="id"))
	@Column(name="nome")
	private Collection<String> contatos;

	// Métodos get e set
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setContatos(Collection<String> contatos) {
		this.contatos = contatos;
	}
	public Collection<String> getContatos() {
		return contatos;
	}
}

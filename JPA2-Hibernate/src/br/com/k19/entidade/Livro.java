package br.com.k19.entidade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private double preco;
	
	@ManyToMany
	// personalizando nome de colunas através da notação JoinTable 
	@JoinTable(name="Livro_Autor",
			joinColumns=@JoinColumn(name="livro_id"),
			inverseJoinColumns=@JoinColumn(name="autor_id"))
	private Collection<Autor> autores = new ArrayList<Autor>();
	
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
	public Collection<Autor> getAutores() {
		return autores;
	}
}

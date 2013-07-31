package br.com.k19.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue
	private Long id;

	// Relacionamento entre entidades (UM Estado PARA UM Governador)
	@OneToOne
	private Governador governador;
	private String nome;
	
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
	public void setGovernador(Governador governador) {
		this.governador = governador;
	}
	public Governador getGovernador() {
		return governador;
	}
	
	/*
	Estado estado = manager.find(Estado.class, 1L);
	Governador g = e.getGovernador();
	*/
}

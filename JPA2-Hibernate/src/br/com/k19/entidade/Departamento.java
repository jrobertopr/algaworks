package br.com.k19.entidade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	public Long id;
	public String nome;
	
	// Relacionamento entre entidades (UM departamento PARA MUITOS funcionários)
	@OneToMany
	
	// personalizando o nome da coluna JoinTable
	@JoinTable(name="DEP_FUNC",
			joinColumns=@JoinColumn(name="DEP_ID"),
			inverseJoinColumns=@JoinColumn(name="FUNC_ID"))
	public Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

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
		this.nome=nome;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}

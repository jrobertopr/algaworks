package br.com.k19.mapeamento;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Candidato {
	private String cpf;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

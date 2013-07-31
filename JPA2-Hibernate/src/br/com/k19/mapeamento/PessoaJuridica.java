package br.com.k19.mapeamento;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Candidato {
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}

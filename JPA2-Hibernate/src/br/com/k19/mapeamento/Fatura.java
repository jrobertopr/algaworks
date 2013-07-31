package br.com.k19.mapeamento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fatura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	// criando relacionamento bidirecional entre as faturas e as ligações
	@OneToMany(mappedBy="fatura")
	private Collection<Ligacao> ligacoes = new ArrayList<Ligacao>();
	
	@Temporal(TemporalType.DATE)
	private Calendar dataVencimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Ligacao> getLigacoes() {
		return ligacoes;
	}
	public void setLigacoes(Collection<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}

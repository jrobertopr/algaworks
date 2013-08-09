package br.com.k19.servico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.k19.entidade.Jogador;
import br.com.k19.entidade.Time;

public class TimeRepository {
	
	private EntityManager manager;
	
	public TimeRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Time time) {
		this.manager.persist(time);
	}
	
	public void remove(Long id) {
		Time time = this.procura(id);
		Query query = this.manager.createQuery("select x from Jogador x");
		@SuppressWarnings("unchecked")
		List<Jogador> jogadores = query.getResultList();
		for(Jogador jogador : jogadores) {
			jogador.setTime(null);
		}
		this.manager.remove(time);
	}
	
	public Time atualiza(Time time) {
		return this.manager.merge(time);
	}
	
	public Time procura(Long id) {
		return this.manager.find(Time.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Time> getLista() {
		Query query = this.manager.createQuery("select x from Time x");
		return query.getResultList();
	}

}

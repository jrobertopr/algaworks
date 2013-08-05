package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.k19.entidade.Editora;

public class EditoraRepository {
	private EntityManager manager;
	
	public EditoraRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	// adiciona editora
	public void adiciona(Editora e) {
		this.manager.persist(e);
	}
	
	// busca editora
	public Editora busca(Long id) {
		return this.manager.find(Editora.class, id);
	}
	
	// lista editoras através do método ArrayList
	@SuppressWarnings("unchecked")
	public List<Editora> buscaTodas() {
		Query query = this.manager.createQuery("SELECT e FROM Editora e");
		return query.getResultList();
	}

}

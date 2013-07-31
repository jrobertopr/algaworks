package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.entidade.Editora;

public class ListaEditorasComJPA {
	public static void main(String[] args) {
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria_pu");
		
		// criando variável manager que recebe entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();

		// criando linguagem de consulta com JPQL
		Query query = manager.createQuery("SELECT e FROM Editora e");
		List<Editora> editoras = query.getResultList();
		
		for(Editora e: editoras) {
			System.out.println("EDITORA: " + e.getId() + " - " + e.getNome() + " - " + e.getEmail());
		}
	}

}

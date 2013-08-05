package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Editora;

public class ListaEditoras {
	public static void main(String[] args) {

		// criando entidade de gerenciamento
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// utilizando repositório
		EditoraRepository editoraRepository = new EditoraRepository(manager);
		List<Editora> editoras = editoraRepository.buscaTodas();

		for(Editora e: editoras) {
			System.out.println("EDITORA: " + e.getNome() + " - " + e.getEmail());
		}
		
		// fechando entidade
		manager.close();
		factory.close();
	}
}

package br.com.k19.testes;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.entidade.Autor;
import br.com.k19.entidade.Livro;

public class TesteConsultaDinamica {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select a from Autor a");
		
		// testando excesão		
		@SuppressWarnings("unchecked")
		List<Autor> autores = query.getResultList();
		
		for(Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
			Collection<Livro> livros = autor.getLivros();
			
			for(Livro livro : livros) {
				System.out.println("Livro: " + livro.getNome());
				System.out.println("Preço: " + livro.getPreco());
			}
			System.out.println();
		}
		// fechando conexao e entidade de gerenciamento
		manager.close();
		factory.close();
	}

}

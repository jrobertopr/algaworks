package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Autor;
import br.com.k19.entidade.Livro;

public class AdicionaDadosComJPA {
	public static void main(String[] args) {

		// criando uma entidade de gerenciamento
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// abrindo transação
		manager.getTransaction().begin();

		Autor autor = new Autor();
		autor.setNome("K-19");
		
		Livro livro = new Livro();
		livro.setNome("JSF");
		livro.getAutores().add(autor);
		
		// persistindo dados
		manager.persist(autor);
		manager.persist(livro);
		
		// encerrando transação salvando todas as alterações
		manager.getTransaction().commit();
		
		// fechando conexao
		manager.close();
		factory.close();
	}
}

package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Livro;
import br.com.k19.entidade.Autor;

public class AdicionaLivroAutor {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// abrindo transação
		manager.getTransaction().begin();
		
		// criando objetos persistindo dados
		
		Livro livro1 = new Livro();
		livro1.setNome("Java para Web");
		livro1.setPreco(59.90);
		manager.persist(livro1);
		
		Livro livro2 = new Livro();
		livro2.setNome("JPA-Hibernate");
		livro2.setPreco(109.90);
		manager.persist(livro2);
		
		Livro livro3 = new Livro();
		livro3.setNome("JSF");
		livro3.setPreco(205.70);
		manager.persist(livro3);
		
		Livro livro4 = new Livro();
		livro4.setNome("Java Use a Cabeça");
		livro4.setPreco(99.90);
		manager.persist(livro4);
		
		Autor autor1 = new Autor();
		autor1.setNome("Caelum");
		manager.persist(autor1);

		Autor autor2 = new Autor();
		autor2.setNome("K-19");
		manager.persist(autor2);

		Autor autor3 = new Autor();
		autor3.setNome("K-19");
		manager.persist(autor3);
		
		Autor autor4 = new Autor();
		autor4.setNome("Pinoquio");
		manager.persist(autor4);
		
		// salvando os dados no banco 
		manager.getTransaction().commit();
		
		// fechando conexao e entidade de gerenciamento
		manager.close();
		factory.close();
	}

}

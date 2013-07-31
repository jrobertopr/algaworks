package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Cliente;

public class GerandoTabelas {
	public static void main(String[] args) {
		
		// criando conex�o
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		
		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();  
        
		// abrindo transa��o
		manager.getTransaction().begin();
		
		// criando objetos
		Cliente cliente = new Cliente();  
		cliente.setNome("Jos� Roberto");

		// persistindo dados
		manager.persist(cliente);
		
		// encerrando transa��o salvando as altera��es
		manager.getTransaction().commit();
		System.out.println("Tabela gerada com sucesso! ");
		
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();
	}
}

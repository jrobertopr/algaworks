package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Cliente;

public class GerandoTabelas {
	public static void main(String[] args) {
		
		// criando conexão
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		
		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();  
        
		// abrindo transação
		manager.getTransaction().begin();
		
		// criando objetos
		Cliente cliente = new Cliente();  
		cliente.setNome("José Roberto");

		// persistindo dados
		manager.persist(cliente);
		
		// encerrando transação salvando as alterações
		manager.getTransaction().commit();
		System.out.println("Tabela gerada com sucesso! ");
		
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();
	}
}

package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Carro;

public class GerandoTabelas {
	public static void main(String[] args) {
		
		// manipulando entidade
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		
		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();  
        
		// abrindo transação
		manager.getTransaction().begin();
		
		// criando objetos
		Carro carro = new Carro();  
		carro.setMarca("Renaut");
		carro.setModelo("Logan");

		// persistindo dados
		manager.persist(carro);
		
		// encerrando transação salvando as alterações
		manager.getTransaction().commit();
		
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();

		System.out.println("Tabela gerada com sucesso! ");

	}

}

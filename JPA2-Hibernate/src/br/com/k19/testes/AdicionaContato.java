package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.mapeamento.Contato;

public class AdicionaContato {
	public static void main(String[] args) {

		// manipulando entidade de gerenciamento
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// abrindo transa��o
		manager.getTransaction().begin();
		
		Contato contato = new Contato();
		contato.setNome("Jo�o da Rocha");
		contato.setEmail("joao_rocha@gmail.com");
		contato.setEndereco("Rua Luciano Alves, 3331");
		contato.setDataNascimento(new GregorianCalendar(1975, 11, 20));
		
		// persistindo dados
		manager.persist(contato);
		
		// encerrando transa��o salvando todas as altera��es
		manager.getTransaction().commit();
		
		// fechando conexao
		manager.close();
		factory.close();
	}
}

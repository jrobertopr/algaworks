package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.mapeamento.Contato;

public class InserirDadosComJPA {
	public static void main(String[] args) {

		// manipulando entidade
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");

		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();
		
		// iniciando transa��o
		manager.getTransaction().begin();
		
		// criando objetos
		Contato novoContato = new Contato();
		novoContato.setNome("Emanuel Rocha");
		novoContato.setEmail("emanuel@hotmail.com");
		novoContato.setEndereco("Avenida dos Jangadeiros, 145");
		novoContato.setDataNascimento(Calendar.getInstance());

		// persistindo dados
		manager.persist(novoContato);

		// encerrando transa��o salvando as altera��es
		manager.getTransaction().commit();
	
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();

		System.out.println("Dados adicionados com sucesso!");

	}

}

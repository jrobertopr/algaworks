package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Time;

public class InserirDadosComJPA {
	public static void main(String[] args) {

		// manipulando entidade
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K19-PU");

		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();
		
		// iniciando transação
		manager.getTransaction().begin();
		
		// criando objetos
		Time novoTime = new Time();
		novoTime.setNome("Vasco");
		novoTime.setTecnico("Caio Menezes");

		// contato.setDataNascimento(new GregorianCalendar(1975, 11, 20));

		// persistindo dados
		manager.persist(novoTime);

		// encerrando transação salvando as alterações
		manager.getTransaction().commit();
	
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();

		System.out.println("Dados adicionados com sucesso!");

	}

}

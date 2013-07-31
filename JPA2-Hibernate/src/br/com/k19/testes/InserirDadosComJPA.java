package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.mapeamento.Contato;

public class InserirDadosComJPA {
	public static void main(String[] args) {

		// criando conexão
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");

		// criando entidade de gerenciamento
		EntityManager manager = factory.createEntityManager();
		
		// iniciando transação
		manager.getTransaction().begin();
		
		// criando objetos
		Contato novoContato = new Contato();
		novoContato.setNome("Karla Erica");
		novoContato.setEmail("karla@hotmail.com");
		novoContato.setEndereco("Rua Domingos Neto, 3331");
		novoContato.setDataNascimento(Calendar.getInstance());

		// persistindo dados
		manager.persist(novoContato);

		// encerrando transação salvando as alterações
		manager.getTransaction().commit();
		System.out.println("Dados adicionados com sucesso!");
		
		// fechando entidade de gerenciamento
		manager.close();
		
		// fechando conexao
		factory.close();
	}

}

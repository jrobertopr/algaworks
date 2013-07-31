package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Usuario;

public class AdicionaUsuario {
	public static void main(String[] args) {

		// criando uma entidade de gerenciamento
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// abrindo transação
		manager.getTransaction().begin();
		
		Usuario usuario = new Usuario();
		usuario.setNome("roberto");
		usuario.setDataDeCadastro(Calendar.getInstance());
		
		// persistindo dados
		manager.persist(usuario);
		
		// encerrando transação salvando todas as alterações
		manager.getTransaction().commit();
		
		// fechando conexao
		manager.close();
		factory.close();
	}
}

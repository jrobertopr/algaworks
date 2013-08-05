package br.com.k19.testes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.entidade.Editora;

public class InsereEditora {
	public static void main(String[] args) {

		// manipulando entidade
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// utilizando repositório de editoras
		EditoraRepository editoraRepository = new EditoraRepository(manager);
		
		// manipulando dados
		Editora novaEditora = new Editora();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da editora: ");
		novaEditora.setNome(entrada.nextLine());
		System.out.println("Digite o email da editora: ");
		novaEditora.setEmail(entrada.nextLine());
		
		// invocando método adiciona
		editoraRepository.adiciona(novaEditora);

		// iniciando transação salvando as alterações
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		System.out.println("Dados adicionados com sucesso!");
		
		// fechando entidade
		manager.close();
		factory.close();
	}

}

package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.mapeamento.Candidato;
import br.com.k19.mapeamento.Endereco;

public class AdicionaCandidatoEndereco {
	public static void main(String[] agrs) {

		// criando conexão e entidade de gerenciamento 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// iniciando transação
		manager.getTransaction().begin();
		
		// criando objetos
		Endereco endereco = new Endereco();
		endereco.setPais("Brasil");
		endereco.setEstado("Ceará");
		endereco.setCidade("Fortaleza");
		endereco.setLogradouro("Rua Luciano Alves, 3331");
		endereco.setComplemento("apto. 08");
		endereco.setBairro("Jangurussu");
		endereco.setCep(60870640);
		
		Candidato candidato = new Candidato();
		candidato.setNome("José Roberto");
		candidato.setDataNascimento(new GregorianCalendar(1977, 06, 24));
		candidato.setEndereco(endereco);
		
		// persistindo dados
		manager.persist(endereco);
		manager.persist(candidato);
		
		// salvando dados no banco
		manager.getTransaction().commit();
		
		// fechando conexao e entidade de gerenciamento
		manager.close();
		factory.close();
		
	}
}

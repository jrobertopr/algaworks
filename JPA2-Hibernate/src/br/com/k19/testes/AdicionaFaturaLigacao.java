package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.mapeamento.Fatura;
import br.com.k19.mapeamento.Ligacao;

public class AdicionaFaturaLigacao {
	public static void main(String[] agrs) {
		// criando entidade de gerenciamento
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		// iniciando transação
		manager.getTransaction().begin();
		
		Ligacao ligacao1 = new Ligacao();
		ligacao1.setDuracao(369);
		
		Ligacao ligacao2 = new Ligacao();
		ligacao2.setDuracao(675);
		
		Fatura fatura = new Fatura();
		fatura.setDataVencimento(new GregorianCalendar(2012, 11, 20));
		
		fatura.getLigacoes().add(ligacao1);
		fatura.getLigacoes().add(ligacao2);
		
		ligacao1.setFatura(fatura);
		ligacao2.setFatura(fatura);
		
		// persistindo dados
		manager.persist(fatura);
		manager.persist(ligacao1);
		manager.persist(ligacao2);
		
		// salva as alterações no banco
		manager.getTransaction().commit();
		
		// fechando conexao
		manager.close();
		factory.close();		
	}
}

package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("controlefinancas");

		EntityManager manager = factory.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Filipe Souza");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();

		System.out.println("Conta gravada com sucesso!");

		long fim = System.currentTimeMillis();
		System.out.println("Executando em: " + (fim - inicio) + "ms");
		
		
		
		long inicio2 = System.currentTimeMillis();

		EntityManager manager2 = new JPAUtil().getEntityManager();

		Conta conta2 = new Conta();
		conta2.setTitular("Dayani Souza");
		conta2.setBanco("Banco do Brasil");
		conta2.setNumero("123456-6");
		conta2.setAgencia("0999");

		manager2.getTransaction().begin();
		manager2.persist(conta2);
		manager2.getTransaction().commit();
		manager2.close();

		System.out.println("Conta gravada com sucesso!");

		long fim2 = System.currentTimeMillis();
		System.out.println("Executando em: " + (fim2 - inicio2) + "ms");
	}

}

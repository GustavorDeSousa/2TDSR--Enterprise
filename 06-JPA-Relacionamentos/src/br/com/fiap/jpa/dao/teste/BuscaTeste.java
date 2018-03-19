package br.com.fiap.jpa.dao.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.NotaDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		NotaDAOImpl dao = new NotaDAOImpl(em);

		//Buscar uma nota fiscal
		NotaFiscal nota=dao.read(1);
		
		//Exibir o CNPJ da Nota
		System.out.println(nota.getCnpj());
		
		//Exibir a descricao do pedido
		System.out.println(nota.getPedido().getDescricao());
		
		em.close();
		fabrica.close();
		
	}
}

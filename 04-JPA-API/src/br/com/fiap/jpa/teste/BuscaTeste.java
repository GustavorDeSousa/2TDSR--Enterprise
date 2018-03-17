package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Bebida;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
			Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Bebida bebida = em.find(Bebida.class, 1);
		
		System.out.println(bebida.getNome());
		
		em.close();
		fabrica.close();
	}
	
}

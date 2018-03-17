package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Bebida;

public class RemoveTeste {

	public static void main(String[] args) {
		//Criar o Entity Manager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma bebida
		Bebida bebida = em.find(Bebida.class, 21);
		
		//Remover a bebida
		em.remove(bebida);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}

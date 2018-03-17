package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Bebida;

//Atualiza o objeto com os dados do banco
public class RefreshTeste {

	public static void main(String[] args) {
		//Criar o EntityManager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma bebida
		Bebida bebida = em.find(Bebida.class, 1);
		
		//Exibir o nome
		System.out.println(bebida.getNome());
		
		//Mudar o nome da bebida no java
		bebida.setNome("Corona");
		
		//Exibir o nome
		System.out.println(bebida.getNome());
		
		//Fazer o refresh
		em.refresh(bebida);
		
		//Exibir o nome
		System.out.println(bebida.getNome());
		
		em.close();
		fabrica.close();
	}
	
}

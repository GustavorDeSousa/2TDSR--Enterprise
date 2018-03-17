package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.entity.TipoBebida;

public class AtualizacaoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
			Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
								//Tabela, Chave primária
		Bebida bebida = //em.find(Bebida.class, 1);
				new Bebida(TipoBebida.CERVEJA, 
						"Kaiser", 
						new GregorianCalendar(2019,Calendar.JANUARY,2), 
						null, true);
		//bebida.setCodigo(1);
		
		em.merge(bebida);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}

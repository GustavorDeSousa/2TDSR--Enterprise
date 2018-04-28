package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerencaTeste {
	public static void main(String[] args) {
		//Cadastrar uma pessoa, pf e pj
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		Pessoa pessoa = new Pessoa("Gustavo", "Netuno");
		
		PessoaFisica pf = new PessoaFisica("Gustavo Rocha", "Av.Netuno", 
				"45052738811", new GregorianCalendar(2014,Calendar.DECEMBER, 20));
		
		PessoaJuridica pj = new PessoaJuridica("Mateus", "Osasco", 
				"5005000/5000", new GregorianCalendar(2015, Calendar.MARCH,10));
		

		try {
			dao.create(pessoa);
			dao.create(pf);
			dao.create(pj);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}

package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.dao.impl.BebidaDAOImpl;
import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.entity.TipoBebida;
import br.com.fiap.jpa.exception.BebidaNaoEncontradaException;
import br.com.fiap.jpa.exception.CommitException;

public class DaoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		BebidaDAO dao = new BebidaDAOImpl(em);
		
		//Cadastrar
		Bebida bebida = new Bebida(TipoBebida.REFRIGERANTE,
				"Pepsi", 
				new GregorianCalendar(2019, Calendar.JUNE, 2),
				null, false);
		
		try {
			dao.cadastrar(bebida);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Bebida bebidaBusca = dao.buscar(bebida.getCodigo());
		System.out.println(bebidaBusca.getNome());
		
		//Atualizar
		bebidaBusca.setNome("Coca-Cola");
		try {
			dao.atualizar(bebidaBusca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(bebidaBusca.getCodigo());
			dao.commit();
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}

}





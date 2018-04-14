package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;

public class ConsoleView2 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);		
		System.out.println("Cliente: " + clienteDAO.contarQuantidade());
		
//		System.out.println("Media precos pacotes: " + pacoteDAO.calcularMediaPreco());
		
		ReservaDAO reservaDAO = new ReservaDAOImpl(em);
		System.out.println("Quantidade de reserva: " + reservaDAO.contarQuantidadeReserva(2));
		
		Calendar inicio = new GregorianCalendar(2017, Calendar.JANUARY,1);
		Calendar fim = new GregorianCalendar(2017, Calendar.DECEMBER,31);
		
		System.out.println("Total de reserva: " + reservaDAO.contarQuantidadePorData(inicio, fim));
		
		em.close();
		fabrica.close();
		
	}
}

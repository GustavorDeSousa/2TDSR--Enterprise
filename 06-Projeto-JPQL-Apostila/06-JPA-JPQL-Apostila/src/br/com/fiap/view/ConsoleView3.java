package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;

public class ConsoleView3 {
		public static void main(String[] args) {
			EntityManagerFactory fabrica = 
					EntityManagerFactorySingleton.getInstance();
			EntityManager em = fabrica.createEntityManager();
		
			ReservaDAO reservaDAO = new ReservaDAOImpl(em);
			List<Reserva> reservas = 
					reservaDAO.buscarPorCidade("Londrina");
			
			for (Reserva reserva : reservas) {
				System.out.println(reserva.getPacote().getDescricao() + " " + reserva.getCliente()
				.getEndereco()
				.getCidade()
				.getNome());
			}
			
			PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
			System.out.println("Pacotes com transportes: "
			+ pacoteDAO.contarPorTransporte());
			
			Calendar i = new GregorianCalendar(2017, Calendar.JANUARY, 1);
			Calendar f = new GregorianCalendar(2018, Calendar.JANUARY, 1);
			
			System.out.println("Soma dos valores: " + pacoteDAO.somarPrecoPorPeriodo(i, f));
			
			List<Pacote> pacotes = pacoteDAO.buscarPorDescricao("a");
			for (Pacote pacote : pacotes) {
				System.out.println(pacote.getDescricao());
			}
			
			em.close();
			fabrica.close();
		}

}

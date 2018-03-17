package br.com.fiap.jpa.dao.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaDAO;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.NotaDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.StatusPedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar Nota e Pedido
		NotaDAO notaDao =  new NotaDAOImpl(em);
		PedidoDAO pedidoDao =  new PedidoDAOImpl(em);
		
		Pedido pedido = new Pedido("Churros", StatusPedido.APROVADO);
		NotaFiscal nota = new NotaFiscal(pedido, 5.50, "FIAP");

		try {
			pedidoDao.create(pedido);
			notaDao.create(nota);
			notaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		fabrica.close();
	}

}

package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar as cidades
		CidadeDAO dao = new CidadeDAOImpl(em);
		List<Cidade> lista = dao.listar();
		
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("Buscar por nome");
		lista = dao.buscarPorNome("a");
		
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("Busacar Clientes: ");
/*		
		ClienteDAO daoCliente = new ClienteDAOImpl(em);
		List<Cliente> listaCliente = daoCliente.listar();
		
		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		fabrica.close();
*/
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar Cliente");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
		TransporteDAO transporteDAO = new TransporteDAOImpl(em);
		Transporte transporte = transporteDAO.pesquisar(1);
		List<Pacote> pacotes = pacoteDAO.buscarPorTransporte(transporte);
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Listar Cliente por estado");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Buscar cliente por dia");
		for (Pacote pacote : pacotes) {
/*			System.out.println(clien));
*/		}
		em.close();
		fabrica.close();
	}

}




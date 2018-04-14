package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		//Criar a query
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e",Cliente.class).setParameter("e", estado).getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("from Reserva r where r.numeroDias = :n",Cliente.class).setParameter("n", dias).getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarQuantidade() {
		return em.createQuery("select count(c) from Cliente c",Long.class).getSingleResult();
	}
}
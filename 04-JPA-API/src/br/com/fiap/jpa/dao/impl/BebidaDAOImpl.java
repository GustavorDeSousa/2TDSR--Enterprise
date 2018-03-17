package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.BebidaDAO;
import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.exception.BebidaNaoEncontradaException;
import br.com.fiap.jpa.exception.CommitException;

public class BebidaDAOImpl implements BebidaDAO {

	private EntityManager em;
	
	public BebidaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Bebida cadastrar(Bebida bebida) {
		em.persist(bebida);
		return bebida;
	}

	@Override
	public Bebida atualizar(Bebida bebida) {
		em.merge(bebida);
		return bebida;
	}

	@Override
	public void remover(int codigo) throws BebidaNaoEncontradaException {
		Bebida bebida = buscar(codigo);
		if (bebida == null)
			throw new BebidaNaoEncontradaException();
		em.remove(bebida);
	}

	@Override
	public Bebida buscar(int codigo) {
		return em.find(Bebida.class, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}
	
}








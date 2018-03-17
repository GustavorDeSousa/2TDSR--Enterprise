package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.NotaDAO;
import br.com.fiap.jpa.entity.NotaFiscal;

public class NotaDAOImpl extends GenericDAOImpl<NotaFiscal, Integer> implements NotaDAO{

	public NotaDAOImpl(EntityManager em) {
		super(em);
	}

}

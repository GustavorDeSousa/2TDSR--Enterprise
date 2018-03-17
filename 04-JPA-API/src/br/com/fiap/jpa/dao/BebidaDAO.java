package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Bebida;
import br.com.fiap.jpa.exception.BebidaNaoEncontradaException;
import br.com.fiap.jpa.exception.CommitException;

public interface BebidaDAO {

	Bebida cadastrar(Bebida bebida);
	Bebida atualizar(Bebida bebida);
	void remover(int codigo) throws BebidaNaoEncontradaException;
	Bebida buscar(int codigo);
	
	void commit() throws CommitException;
	
}
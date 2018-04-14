package br.com.fiap.dao;

import java.util.Calendar;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{
	
	long contarQuantidadeReserva(int idCliente);
	
	long contarQuantidadePorData(Calendar inicio, Calendar fim);

}

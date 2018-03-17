package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.SorveteDAO;
import br.com.fiap.jpa.dao.impl.SorveteDAOImpl;
import br.com.fiap.jpa.entity.Sorvete;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class SorveteTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		//Cadastrar
		Sorvete sorvete = new Sorvete("Chocolate Belga", 15);
		SorveteDAO dao = new SorveteDAOImpl(em);
		
		try {
			dao.create(sorvete);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Buscar
		Sorvete busca = dao.read(sorvete.getCodigo());
		System.out.println(busca.getSabor());
		
		//Atualizar
		busca.setSabor("Chocolate Belga com Doce de Leite");
		try {
			dao.update(busca);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}

		//Remover
		try {
			dao.delete(busca.getCodigo());
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
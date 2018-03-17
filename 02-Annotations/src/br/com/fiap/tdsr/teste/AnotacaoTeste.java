package br.com.fiap.tdsr.teste;

import java.lang.reflect.Field;

import br.com.fiap.tdsr.anotacao.ValidaVazio;
import br.com.fiap.tdsr.bean.Time;

public class AnotacaoTeste {

	public static void main(String[] args) {
		Time time = new Time("Noroeste",0);
		
		//Recupera o nome da classe
		String nome = time.getClass().getSimpleName();
		System.out.println("Nome da classe: " + nome);
		
		//Recuperar os atributos
		Field[] attrs = time.getClass().getDeclaredFields();
		for (Field field : attrs) {
			//Recuperar a anotação
			ValidaVazio anotacao =  
					field.getAnnotation(ValidaVazio.class);
			if (anotacao != null) {
				System.out.println(field.getName());
				System.out.println(anotacao.mensagem());
			}
		}
	}
	
}

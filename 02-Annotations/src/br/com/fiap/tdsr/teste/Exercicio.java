package br.com.fiap.tdsr.teste;

import br.com.fiap.tdsr.anotacao.Tabela;
import br.com.fiap.tdsr.bean.Aluno;
import br.com.fiap.tdsr.bean.Time;

public class Exercicio {

	public static void main(String[] args) {
		Time time = new Time("Criciuma",21);
		Aluno aluno = new Aluno();
		
		Tabela tabela = time.getClass()
						.getAnnotation(Tabela.class);
		System.out.println("select * from "+
						tabela.nome());
		
		Tabela tabela2 = aluno.getClass()
						.getAnnotation(Tabela.class);
		System.out.println("select * from "+
						tabela2.nome());		
		
	}
	
}





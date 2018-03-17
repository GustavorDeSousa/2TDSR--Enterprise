package br.com.fiap.tdsr.teste;

import java.util.Date;
import java.util.Scanner;

public class Teste {

	@SuppressWarnings("resource")
	public String ler() {
		Scanner sc = new Scanner(System.in);
		Date data = new Date(""); //@Deprecated
		return sc.nextLine();
	}
	
}

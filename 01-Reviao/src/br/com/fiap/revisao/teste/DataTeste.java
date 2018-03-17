package br.com.fiap.revisao.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataTeste {

	public static void main(String[] args) {
		//Criar uma data
		Calendar hoje = Calendar.getInstance();
		//Criar um formatador de data
		SimpleDateFormat format = 
				new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(format.format(hoje.getTime()));
		
		//Transformar uma string em data
		String formatura = "12/12/2018";
		try {
			System.out.println(format.parse(formatura));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Criar um data especifica
		Calendar carnaval = 
			new GregorianCalendar(2018, Calendar.FEBRUARY, 13);
		System.out.println(format.format(carnaval.getTime()));
	}
	
}



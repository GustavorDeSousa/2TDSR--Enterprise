package br.com.fiap.tdsr.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//A anotação será mantida até a execução
@Retention(RetentionPolicy.RUNTIME)
//Determina para quem se destina a anotação 
@Target(ElementType.FIELD) //(Atributo)
public @interface ValidaVazio {

	String mensagem();
	
}
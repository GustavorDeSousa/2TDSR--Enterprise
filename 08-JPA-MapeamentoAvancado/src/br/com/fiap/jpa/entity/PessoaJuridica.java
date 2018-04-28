package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
	
	private String cnpj;
	
	private Calendar dataFundacao;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, String endereco, String cnpj, Calendar dataFundacao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
}

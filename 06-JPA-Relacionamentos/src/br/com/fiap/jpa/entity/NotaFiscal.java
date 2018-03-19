package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NOTA_FISCAL")
@SequenceGenerator(name="nota", sequenceName="SQ_T_NOTA_FISCAL", allocationSize=1)
public class NotaFiscal {

	@Id
	@GeneratedValue(generator="nota", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_codigo")
	private int codigo;
	
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.REMOVE,CascadeType.PERSIST})
	@JoinColumn(name="cod_pagamento")
	private Pedido pedido;

	@Column(name="vl_valor", nullable = false)
	private double valor;
	
	@Column(name="nr_cnpj")
	private String cnpj;

	public NotaFiscal() {
		super();
	}

	public NotaFiscal(Pedido pedido, double valor, String cnpj) {
		super();
		this.pedido = pedido;
		this.valor = valor;
		this.cnpj = cnpj;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	


	
}

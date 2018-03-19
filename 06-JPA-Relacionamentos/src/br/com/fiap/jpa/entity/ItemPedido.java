package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_PEDIDO")
@SequenceGenerator(name="itemPedido", sequenceName="SQ_T_ITEM_PEDIDO", allocationSize=1)
public class ItemPedido {
	
	@Id
	@GeneratedValue(generator="itemPedido", strategy=GenerationType.SEQUENCE)
	@Column(name="CD_ITEMPEDIDO")
	private int codigo;
	
	@Column(name="QT_ITEMPRODUTO")
	private int quantidade;
	
	
	@Column(name="VL_ITEMPRODUTO")
	private double valor;
	
	@ManyToMany
	@JoinColumn(name="CD_PEDIDO")
	private Pedido pedido;

	public ItemPedido() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}

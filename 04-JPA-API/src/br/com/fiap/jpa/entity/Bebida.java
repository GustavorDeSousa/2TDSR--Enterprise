package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_BEBIDA")
@SequenceGenerator(name="bebida",sequenceName="SQ_TB_BEBIDA",allocationSize=1)
public class Bebida {

	@Id
	@Column(name="cd_bebida")
	@GeneratedValue(generator="bebida",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_tipo")
	private TipoBebida tipo;
	
	@Column(name="nm_bebida",nullable=false,length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Calendar dataValidade;

	@Lob
	@Column(name="fl_rotulo")
	private byte[] rotulo;
	
	@Column(name="st_alcoolico")
	private boolean alcoolico;
	
	public Bebida(TipoBebida tipo, String nome, Calendar dataValidade, byte[] rotulo, boolean alcoolico) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.rotulo = rotulo;
		this.alcoolico = alcoolico;
	}

	public Bebida() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoBebida getTipo() {
		return tipo;
	}

	public void setTipo(TipoBebida tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public byte[] getRotulo() {
		return rotulo;
	}

	public void setRotulo(byte[] rotulo) {
		this.rotulo = rotulo;
	}

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
	
}

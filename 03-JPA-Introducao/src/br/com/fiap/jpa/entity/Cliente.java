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
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente",sequenceName="SQ_TB_CLIENTE",allocationSize=1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(generator="cliente",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nm_cliente",nullable=false,length=150)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento",nullable=false)
	private Calendar dataNascimento;
	
	@Column(name="nr_cartao_fidelidade")
	private Integer cartaoFidelidade;
	
	@Column(name="ds_sexo",nullable=false)
	private Sexo sexo;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_status",nullable=false)
	private Status status;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, Calendar dataNascimento, Integer cartaoFidelidade, Sexo sexo, byte[] foto,
			Status status) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cartaoFidelidade = cartaoFidelidade;
		this.sexo = sexo;
		this.foto = foto;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCartaoFidelidade() {
		return cartaoFidelidade;
	}

	public void setCartaoFidelidade(Integer cartaoFidelidade) {
		this.cartaoFidelidade = cartaoFidelidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
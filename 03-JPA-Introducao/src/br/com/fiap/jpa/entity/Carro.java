package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CARRO")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {

	@Id
	@Column(name = "CD_CARRO")
	@GeneratedValue(generator = "carro", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "DS_MODELO", nullable = false, length = 100)
	private String modelo;

	// Classe wrapper (Integer) para valores nulos
	@Column(name = "NR_ANO")
	private Integer ano;

	@Column(name = "DS_MOTOR", length = 10)
	private String motor;

	@Column(name = "DS_MONTADORA")
	private String montadora;

	@Column(name = "DS_PLACA", nullable = false, length = 8)
	private String placa;

	@Column(name = "DT_FABRICACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataFabricacao;

	@Column(name = "FG_COLECIONADOR")
	private boolean colecionador;

	@Transient // Não será mapeado para uma coluna no bd
	private boolean pagaIpva;

	@Lob // gravar arquivo no banco de dados (BLOB)
	@Column(name = "FL_FOTO")
	private byte[] foto;

	@Enumerated(EnumType.STRING)
	@Column(name = "DS_TRANSMISSAO")
	private Transmissao transmissao;

	public Carro() {
		super();
	}

	public Carro(String modelo, Integer ano, String motor, String montadora, String placa, Calendar dataFabricacao,
			boolean colecionador, boolean pagaIpva, byte[] foto, Transmissao transmissao) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.motor = motor;
		this.montadora = montadora;
		this.placa = placa;
		this.dataFabricacao = dataFabricacao;
		this.colecionador = colecionador;
		this.pagaIpva = pagaIpva;
		this.foto = foto;
		this.transmissao = transmissao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public boolean isColecionador() {
		return colecionador;
	}

	public void setColecionador(boolean colecionador) {
		this.colecionador = colecionador;
	}

	public boolean isPagaIpva() {
		return pagaIpva;
	}

	public void setPagaIpva(boolean pagaIpva) {
		this.pagaIpva = pagaIpva;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Transmissao getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(Transmissao transmissao) {
		this.transmissao = transmissao;
	}

}

package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
public class Medico {
	
	@Id
	@Column(name="nr_crm")
	private int nr_crm;
	
	@Column(name="nm_medico")
	private String nm_medico;
	
	public Medico() {
		super();
	}
	public Medico(int nr_crm, String nm_medico) {
		super();
		this.nr_crm = nr_crm;
		this.nm_medico = nm_medico;
	}
	public int getNr_crm() {
		return nr_crm;
	}
	public void setNr_crm(int nr_crm) {
		this.nr_crm = nr_crm;
	}
	public String getNm_medico() {
		return nm_medico;
	}
	public void setNm_medico(String nm_medico) {
		this.nm_medico = nm_medico;
	} 
	
	
}

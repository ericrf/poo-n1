package edu.fae.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * 
 * @author robsonluz
 *
 */
@Entity
public class Sessao implements Model {
	private Long id;
	private Date data;
	private int ingressosVendidos;
	private Filme filme;
	private Sala sala;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIngressosVendidos() {
		return ingressosVendidos;
	}
	public void setIngressosVendidos(int ingressosVendidos) {
		this.ingressosVendidos = ingressosVendidos;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Transient
	public int getQtdeDisponivel(){
		int x = sala.getCapacidade() - getIngressosVendidos();
		return x;
	}
	
	
	
}

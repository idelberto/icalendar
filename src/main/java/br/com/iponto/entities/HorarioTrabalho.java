package br.com.iponto.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HorarioTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column
	Integer usuario;

	@Column
	Date dia;

	@Column
	Time entrada;

	@Column
	Time saidaAlmoco;

	@Column
	Time retornoAlmoco;

	@Column
	Time saida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getEntrada() {
		return entrada;
	}

	public void setEntrada(Time entrada) {
		this.entrada = entrada;
	}

	public Time getSaidaAlmoco() {
		return saidaAlmoco;
	}

	public void setSaidaAlmoco(Time saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	public Time getRetornoAlmoco() {
		return retornoAlmoco;
	}

	public void setRetornoAlmoco(Time retornoAlmoco) {
		this.retornoAlmoco = retornoAlmoco;
	}

	public Time getSaida() {
		return saida;
	}

	public void setSaida(Time saida) {
		this.saida = saida;
	}

	public HorarioTrabalho(Integer usuario, Date dia, Time entrada, Time saidaAlmoco, Time retornoAlmoco, Time saida) {
		super();
		this.usuario = usuario;
		this.dia = dia;
		this.entrada = entrada;
		this.saidaAlmoco = saidaAlmoco;
		this.retornoAlmoco = retornoAlmoco;
		this.saida = saida;
	}

}

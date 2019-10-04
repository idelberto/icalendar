/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iponto.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity //
@Table(name = "HorarioTrabalho") //
@NamedQueries({ //
		@NamedQuery(name = "HorarioTrabalho.findAll", query = "SELECT h FROM HorarioTrabalho h"), //
		@NamedQuery(name = "HorarioTrabalho.findById", query = "SELECT h FROM HorarioTrabalho h WHERE h.id = :id"), //
		@NamedQuery(name = "HorarioTrabalho.findByDia", query = "SELECT h FROM HorarioTrabalho h WHERE h.dia = :dia"), //
		@NamedQuery(name = "HorarioTrabalho.findByEntrada", query = "SELECT h FROM HorarioTrabalho h WHERE h.entrada = :entrada"), //
		@NamedQuery(name = "HorarioTrabalho.findBySaidaAlmoco", query = "SELECT h FROM HorarioTrabalho h WHERE h.saidaAlmoco = :saidaAlmoco"), //
		@NamedQuery(name = "HorarioTrabalho.findByRetornoAlmoco", query = "SELECT h FROM HorarioTrabalho h WHERE h.retornoAlmoco = :retornoAlmoco"), //
		@NamedQuery(name = "HorarioTrabalho.findBySaida", query = "SELECT h FROM HorarioTrabalho h WHERE h.saida = :saida") }) //
public class HorarioTrabalho implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Short id;

	@Basic(optional = false)
	@NotNull
	@Column(name = "dia")
	private short dia;

	@Basic(optional = false)
	@NotNull
	@Column(name = "entrada")
	@Temporal(TemporalType.TIME)
	private Date entrada;

	@Basic(optional = false)
	@NotNull
	@Column(name = "saidaAlmoco")
	@Temporal(TemporalType.TIME)
	private Date saidaAlmoco;

	@Basic(optional = false)
	@NotNull
	@Column(name = "retornoAlmoco")
	@Temporal(TemporalType.TIME)
	private Date retornoAlmoco;

	@Basic(optional = false)
	@NotNull
	@Column(name = "saida")
	@Temporal(TemporalType.TIME)
	private Date saida;

	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Usuario usuario;

	public HorarioTrabalho() {
	}

	public HorarioTrabalho(final Short id) {
		this.id = id;
	}

	public HorarioTrabalho(final Short id, final short dia, final Date entrada, final Date saidaAlmoco, final Date retornoAlmoco, final Date saida) {
		this.id = id;
		this.dia = dia;
		this.entrada = entrada;
		this.saidaAlmoco = saidaAlmoco;
		this.retornoAlmoco = retornoAlmoco;
		this.saida = saida;
	}

	public Short getId() {
		return id;
	}

	public void setId(final Short id) {
		this.id = id;
	}

	public short getDia() {
		return dia;
	}

	public void setDia(final short dia) {
		this.dia = dia;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(final Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaidaAlmoco() {
		return saidaAlmoco;
	}

	public void setSaidaAlmoco(final Date saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	public Date getRetornoAlmoco() {
		return retornoAlmoco;
	}

	public void setRetornoAlmoco(final Date retornoAlmoco) {
		this.retornoAlmoco = retornoAlmoco;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(final Date saida) {
		this.saida = saida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += id != null ? id.hashCode() : 0;
		return hash;
	}

	@Override
	public boolean equals(final Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof HorarioTrabalho)) {
			return false;
		}
		final HorarioTrabalho other = (HorarioTrabalho) object;
		if (this.id == null && other.id != null || this.id != null && !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.iponto.entities.HorarioTrabalho[ id=" + id + " ]";
	}

}

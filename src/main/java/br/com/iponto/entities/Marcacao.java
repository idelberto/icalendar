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
import javax.validation.constraints.Size;

@Entity //
@Table(name = "Marcacao") //
@NamedQueries({ //
		@NamedQuery(name = "Marcacao.findAll", query = "SELECT m FROM Marcacao m"), //
		@NamedQuery(name = "Marcacao.findById", query = "SELECT m FROM Marcacao m WHERE m.id = :id"), //
		@NamedQuery(name = "Marcacao.findByData", query = "SELECT m FROM Marcacao m WHERE m.data = :data"), //
		@NamedQuery(name = "Marcacao.findByHora", query = "SELECT m FROM Marcacao m WHERE m.hora = :hora"), //
		@NamedQuery(name = "Marcacao.findByObservacao", query = "SELECT m FROM Marcacao m WHERE m.observacao = :observacao") }) //
public class Marcacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Basic(optional = false)
	@NotNull
	@Column(name = "hora")
	@Temporal(TemporalType.TIME)
	private Date hora;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "observacao")
	private String observacao;

	@JoinColumn(name = "tipo", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TipoMarcacao tipo;

	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Usuario usuario;

	public Marcacao() {
	}

	public Marcacao(final Integer id) {
		this.id = id;
	}

	public Marcacao(final Integer id, final Date data, final Date hora, final String observacao) {
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(final Date hora) {
		this.hora = hora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	public TipoMarcacao getTipo() {
		return tipo;
	}

	public void setTipo(final TipoMarcacao tipo) {
		this.tipo = tipo;
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
		if (!(object instanceof Marcacao)) {
			return false;
		}
		final Marcacao other = (Marcacao) object;
		if (this.id == null && other.id != null || this.id != null && !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.iponto.entities.Marcacao[ id=" + id + " ]";
	}

}

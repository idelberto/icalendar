/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iponto.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //
@Table(name = "TipoMarcacao") //
@NamedQueries({ //
		@NamedQuery(name = "TipoMarcacao.findAll", query = "SELECT t FROM TipoMarcacao t"), //
		@NamedQuery(name = "TipoMarcacao.findById", query = "SELECT t FROM TipoMarcacao t WHERE t.id = :id"), //
		@NamedQuery(name = "TipoMarcacao.findByTipo", query = "SELECT t FROM TipoMarcacao t WHERE t.tipo = :tipo") }) //
public class TipoMarcacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "tipo")
	private String tipo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
	private List<Marcacao> marcacaoList;

	public TipoMarcacao() {
	}

	public TipoMarcacao(final Integer id) {
		this.id = id;
	}

	public TipoMarcacao(final Integer id, final String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public List<Marcacao> getMarcacaoList() {
		return marcacaoList;
	}

	public void setMarcacaoList(final List<Marcacao> marcacaoList) {
		this.marcacaoList = marcacaoList;
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
		if (!(object instanceof TipoMarcacao)) {
			return false;
		}
		final TipoMarcacao other = (TipoMarcacao) object;
		if (this.id == null && other.id != null || this.id != null && !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.iponto.entities.TipoMarcacao[ id=" + id + " ]";
	}

}

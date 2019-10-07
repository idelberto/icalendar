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
@Table(name = "Usuario") //
@NamedQueries({ //
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"), //
		@NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"), //
		@NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"), //
		@NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"), //
		@NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"), //
		@NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo") }) //
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "nome")
	private String nome;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "senha")
	private String senha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ativo")
	private short ativo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Marcacao> marcacaoList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<HorarioTrabalho> horarioTrabalhoList;

	public Usuario() {
	}

	public Usuario(final Integer id) {
		this.id = id;
	}

	public Usuario(final Integer id, final String nome, final String email, final String senha, final short ativo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public short getAtivo() {
		return ativo;
	}

	public void setAtivo(final short ativo) {
		this.ativo = ativo;
	}

	public List<Marcacao> getMarcacaoList() {
		return marcacaoList;
	}

	public void setMarcacaoList(final List<Marcacao> marcacaoList) {
		this.marcacaoList = marcacaoList;
	}

	public List<HorarioTrabalho> getHorarioTrabalhoList() {
		return horarioTrabalhoList;
	}

	public void setHorarioTrabalhoList(final List<HorarioTrabalho> horarioTrabalhoList) {
		this.horarioTrabalhoList = horarioTrabalhoList;
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
		if (!(object instanceof Usuario)) {
			return false;
		}
		final Usuario other = (Usuario) object;
		if (this.id == null && other.id != null || this.id != null && !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.iponto.entities.Usuario[ id=" + id + " ]";
	}

}

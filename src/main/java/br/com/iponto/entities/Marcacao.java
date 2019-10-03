package br.com.iponto.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.iponto.Pessoa;

@Entity
public class Marcacao {

    @Id
    @GeneratedValue
    Integer id;

    @ManyToOne(optional = false)
    Pessoa usuario;
    
    @Column(nullable = false)
    LocalDate data;
    
    @Column(nullable = false)
    LocalTime hora;

    @Column(length = 150, nullable = false)   
    String observacao;

    public Marcacao(Pessoa usuario, LocalDate data, LocalTime hora, String observacao){
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }
        
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Pessoa getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Pessoa usuario){
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao){
        this.observacao = observacao;
    }


} 


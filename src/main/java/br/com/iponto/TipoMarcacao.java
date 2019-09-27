package br.com.iponto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoMarcacao{

    @Id
    @GeneratedValue
    Integer id;

    @Column(length = 25, nullable = false)
    String nome;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }    

    public TipoMarcacao(String nome){        

        this.nome = nome;
    }
}

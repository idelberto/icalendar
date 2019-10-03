package br.com.iponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.Marcacao;

@Repository
public interface MarcacaoRepositorio extends JpaRepository<Marcacao, Integer>{
    
}

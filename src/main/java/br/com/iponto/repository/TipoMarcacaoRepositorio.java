package br.com.iponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.TipoMarcacao;

@Repository
public interface TipoMarcacaoRepositorio extends JpaRepository<TipoMarcacao, Integer>{

}
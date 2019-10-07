package br.com.iponto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.TipoMarcacao;

@Repository
public interface TipoMarcacaoRepository extends CrudRepository<TipoMarcacao, Integer> {

}
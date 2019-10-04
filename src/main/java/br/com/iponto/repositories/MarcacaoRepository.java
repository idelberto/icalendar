package br.com.iponto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.Marcacao;

@Repository
public interface MarcacaoRepository extends CrudRepository<Marcacao, Integer> {

}

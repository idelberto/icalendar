package br.com.iponto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.HorarioTrabalho;

@Repository
public interface HorarioTrabalhoRepository extends CrudRepository<HorarioTrabalho, Integer>{

}

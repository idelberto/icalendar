package br.com.iponto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.HorarioTrabalho;

@Repository
public interface HorarioTrabalhoRepository extends CrudRepository<HorarioTrabalho, Short> {

}

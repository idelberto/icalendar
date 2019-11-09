package br.com.iponto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iponto.entities.HorarioTrabalho;

@Repository
public interface HorarioTrabalhoRepository extends JpaRepository<HorarioTrabalho, Short> {

}

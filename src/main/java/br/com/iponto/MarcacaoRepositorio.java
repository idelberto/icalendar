package br.com.iponto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacaoRepositorio extends CrudRepository<Marcacao, Integer>{
    
}

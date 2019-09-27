package br.com.iponto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iponto.entities.HorarioTrabalho;
import br.com.iponto.repository.HorarioTrabalhoRepository;

@Service
public class HorarioTrabalhoService {

	@Autowired
	private HorarioTrabalhoRepository hhtrabrep;
	
	
	public Optional<HorarioTrabalho> findById(Integer id) {
		return hhtrabrep.findById(id);
	}	

	public HorarioTrabalho save(HorarioTrabalho horarioTrabalho) {
		return hhtrabrep.save(horarioTrabalho);
	}

	public void deleteById(Integer id) {
		hhtrabrep.deleteById(id);
	}			
	
}

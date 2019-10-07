package br.com.iponto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iponto.entities.HorarioTrabalho;
import br.com.iponto.repositories.HorarioTrabalhoRepository;

@Service
public class HorarioTrabalhoService {

	@Autowired
	private HorarioTrabalhoRepository hhtrabrep;

	public Optional<HorarioTrabalho> findById(final Short id) {
		return hhtrabrep.findById(id);
	}

	public HorarioTrabalho save(final HorarioTrabalho horarioTrabalho) {
		return hhtrabrep.save(horarioTrabalho);
	}

	public void deleteById(final Short id) {
		hhtrabrep.deleteById(id);
	}

}

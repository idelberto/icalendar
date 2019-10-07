package br.com.iponto.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.iponto.entities.HorarioTrabalho;
import br.com.iponto.services.HorarioTrabalhoService;

@RestController
@RequestMapping(value = "/horariosTrabalho")
public class HorarioTrabalhoResource {

	@Autowired
	private HorarioTrabalhoService hhtrep;

	@GetMapping
	public ResponseEntity<HorarioTrabalho> find() {

		return null;

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<HorarioTrabalho> findById(@PathVariable final Short id) {
		return hhtrep.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<HorarioTrabalho> create(@Valid @RequestBody final HorarioTrabalho horarioTrabalho) {
		final HorarioTrabalho obj = hhtrep.save(horarioTrabalho);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping
	public ResponseEntity<HorarioTrabalho> update(@RequestBody final HorarioTrabalho horarioTrabalho) {
		return hhtrep.findById(horarioTrabalho.getId()).map(record -> {
			record.setDia(horarioTrabalho.getDia());
			record.setEntrada(horarioTrabalho.getEntrada());
			record.setSaidaAlmoco(horarioTrabalho.getSaidaAlmoco());
			record.setRetornoAlmoco(horarioTrabalho.getRetornoAlmoco());

			final HorarioTrabalho updated = hhtrep.save(record);
			return ResponseEntity.accepted().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable final Short id) {
		return hhtrep.findById(id).map(record -> {
			hhtrep.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}

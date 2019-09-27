package br.com.iponto.resources;

import java.net.URI;
import java.sql.Date;
import java.sql.Time;

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

		HorarioTrabalho hhtrab;
		hhtrab = hhtrep.save(new HorarioTrabalho(1, new Date(2019, 7, 1), new Time(8, 0, 0), new Time(12, 0, 0), new Time(13, 30, 0), new Time(18, 0, 0)));
		return ResponseEntity.ok().body(hhtrab);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<HorarioTrabalho> findById(@PathVariable Integer id) {
		return hhtrep.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<HorarioTrabalho> create(@Valid @RequestBody HorarioTrabalho horarioTrabalho) {
		HorarioTrabalho obj = hhtrep.save(horarioTrabalho);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping
	public ResponseEntity<HorarioTrabalho> update(@RequestBody HorarioTrabalho horarioTrabalho) {
		return hhtrep.findById(horarioTrabalho.getId()).map(record -> {
			record.setDia(horarioTrabalho.getDia());
			record.setEntrada(horarioTrabalho.getEntrada());
			record.setSaidaAlmoco(horarioTrabalho.getSaidaAlmoco());
			record.setRetornoAlmoco(horarioTrabalho.getRetornoAlmoco());			
			
			HorarioTrabalho updated = hhtrep.save(record);
			return ResponseEntity.accepted().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return hhtrep.findById(id).map(record -> {
			hhtrep.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}

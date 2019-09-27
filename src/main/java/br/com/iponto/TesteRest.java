package br.com.iponto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class TesteRest {
	
	@Autowired
	private PessoaRepositorio pr;

	@GetMapping	
	public Pessoa helloWorld() {
		
		Pessoa p;

		p = pr.save(new Pessoa("Jorge", 18));
		
		return p;
	}

}

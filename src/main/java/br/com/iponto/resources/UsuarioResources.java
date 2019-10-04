package br.com.iponto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iponto.dominio.Usuario;
import br.com.iponto.exception.UsuarioNaoEncontradoException;
import br.com.iponto.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api")
public class UsuarioResources {
	
	@Autowired
	private final UsuarioRepositorio usuarioRepositorio;

	UsuarioResources(UsuarioRepositorio repositorio) {
		
		this.usuarioRepositorio = repositorio;
		    
	}

	@GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){  	
		
		return ResponseEntity.ok().body(usuarioRepositorio.findAll());
	
	}
	
	@GetMapping("/usuarios/{id}")
	Usuario getUsuario(@PathVariable Integer id) {
		
		return usuarioRepositorio.findById(id)
			.orElseThrow(() -> new UsuarioNaoEncontradoException(id));
		
    }
	
	@DeleteMapping("/usuarios/{id}")
	void deleteUsuario(@PathVariable Integer id) {
		
		if (usuarioRepositorio.existsById(id)) {		
			usuarioRepositorio.deleteById(id);			
		} else {			
			new UsuarioNaoEncontradoException("Não foi possivel excluir o usuario");			
		}
	
	}
	
	@PostMapping("/usuario")
	public Usuario insertUsuario(@RequestBody Usuario usuario) {
		
	   return usuarioRepositorio.save(usuario);
	
	}
	
}

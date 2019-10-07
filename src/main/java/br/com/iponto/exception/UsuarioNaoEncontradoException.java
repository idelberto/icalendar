package br.com.iponto.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 2349659212172072859L;

	public UsuarioNaoEncontradoException(Integer  id) {
		
		super("Não foi possivel encontrar o usuário " + id);
	
	}
	
	public UsuarioNaoEncontradoException(String mensagem) {
		
		super(mensagem);
		
	}

}

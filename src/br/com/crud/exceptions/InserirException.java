package br.com.crud.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * insers�o de dados na base.
 *
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class InserirException extends SQLException {

	private static final long serialVersionUID = 1491592625876437151L;

	public InserirException(String message) {
		super(message);
	}

	public InserirException(String message, Throwable cause) {
		super(message, cause);
	}
}

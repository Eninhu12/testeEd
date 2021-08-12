package br.com.enio.testeEd.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NaoExisteException(final Long id) {
		super("Perfume id " + id + " não existe.");
	}
}

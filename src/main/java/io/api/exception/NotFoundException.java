package io.api.exception;

public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2541428354859362313L;

	public NotFoundException(long id) {
        super("Id " + id + " não encontrado");
    }
}

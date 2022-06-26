package senai.topicos.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

    private static final long serialVersionUID = -5848473008348423269L;

    private HttpStatus httpStatus;

    public GenericException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

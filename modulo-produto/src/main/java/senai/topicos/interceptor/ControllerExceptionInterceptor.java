package senai.topicos.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import senai.topicos.dto.response.ErrorResponse;
import senai.topicos.exception.GenericException;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionInterceptor {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(GenericException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatus(ex.getHttpStatus());
        log.error("Ocorreu um erro: {}", ex.getMessage());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }


}

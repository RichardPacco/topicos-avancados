package senai.topicos.interceptor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> asdasasdasd(MethodArgumentNotValidException ex) {
        List<ErrorResponse> responses = Lists.newArrayList();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(error.getDefaultMessage());
            responses.add(errorResponse);
        });

        return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
    }
}

package br.com.pontta.pontta.infra.configs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.pontta.pontta.infra.exceptions.ApiError;
import br.com.pontta.pontta.infra.exceptions.CampoInvalido;

@RestControllerAdvice
public class RestControllerException {
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleResponseStatusException(ResponseStatusException exception) {
        ApiError apiError = new ApiError();
        apiError.setErro(exception.getReason());
        apiError.setStatus(exception.getStatusCode().value());
        return ResponseEntity.status(exception.getStatusCode().value()).body(apiError);
    }

    @ExceptionHandler()
    public ResponseEntity<ApiError> handlerValidation(MethodArgumentNotValidException exception) {
        List<CampoInvalido> campoInvalidos = exception.getFieldErrors().stream().map(x -> new CampoInvalido(x.getField(), x.getDefaultMessage())).toList();
        ApiError apiError = new ApiError();
        apiError.setErro("Erro na validacao dos campos");
        apiError.setStatus(exception.getStatusCode().value());
        apiError.setCamposInvalidos(campoInvalidos);
        return ResponseEntity.badRequest().body(apiError);
    }

}

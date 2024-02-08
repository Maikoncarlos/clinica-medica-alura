package com.github.maikoncarlos.clinicamedicaalura.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity<String> tratarNotFoundException() {
        var error = "id não encontrado em nossa base!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErros>> tratarNotValidException(MethodArgumentNotValidException exception) {
        var errorList = exception.getFieldErrors();
        List<DadosErros> error = errorList.stream().map(DadosErros::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    private record DadosErros(String campo, String mensagemError) {
        private DadosErros(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler (DataIntegrityViolationException.class)
    public ResponseEntity<String> tratarViolationException(DataIntegrityViolationException exception) {
        var error = "email já cadastrado!";
        return ResponseEntity.badRequest().body(error);
    }


}

package com.github.maikoncarlos.clinicamedicaalura.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity<Void> tratarNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}

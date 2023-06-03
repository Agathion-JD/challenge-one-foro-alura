package com.alura.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.context.support.DefaultMessageSourceResolvable;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TratamientoErrores {
    @ControllerAdvice
    public class CustomExceptionHandler {

        @ExceptionHandler(NoSuchElementException.class)
        public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Elemento no encontrado");
        }

        @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
        public ResponseEntity<String> handleInvalidStateException(RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
            List<String> errors = ex.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

    }
}

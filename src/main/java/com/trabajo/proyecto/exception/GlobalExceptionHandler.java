package com.trabajo.proyecto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (msg1, msg2) -> msg1 // si hay campos repetidos
                ));

        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(TitleAndDirectorExisteException.class)
    public ResponseEntity<String> handleTitleAndDirectorExisteException(TitleAndDirectorExisteException ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(DocumentalAnd1920Exception.class)
    public ResponseEntity<String> handleDocumentalAnd1920Exception(DocumentalAnd1920Exception ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

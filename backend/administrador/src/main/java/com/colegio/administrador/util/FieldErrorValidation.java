package com.colegio.administrador.util;

import org.springframework.validation.FieldError;

public record FieldErrorValidation(String campo, String error) {
    public FieldErrorValidation(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}

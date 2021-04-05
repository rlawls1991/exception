package com.exception.controllerAdvice.error;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;

@Getter
@NoArgsConstructor
public class ErrorsResource {

    private String message;
    private int status;
    private Errors errors;
    private String code;
}
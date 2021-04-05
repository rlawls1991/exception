package com.exception.controllerAdvice.error;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
@AllArgsConstructor
@Builder
public class ErrorsResource {

    private String message;
    private int status;
    private Errors errors;
    private String code;
}
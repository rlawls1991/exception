package com.exception.controllerAdvice;

import com.exception.controllerAdvice.error.ErrorsResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorsResource resource = ErrorsResource.builder()
                .message("잘못된 값 바인딩")
                .errors(e)
                .status(400)
                .build();

        return new ResponseEntity<>(resource, HttpStatus.BAD_REQUEST);
    }
}

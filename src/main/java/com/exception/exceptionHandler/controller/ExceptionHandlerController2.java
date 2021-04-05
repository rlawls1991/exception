package com.exception.exceptionHandler.controller;

import com.exception.exceptionHandler.exception.NullPointException;
import com.exception.exceptionHandler.exception.SampleException;
import com.exception.exceptionHandler.service.ExceptionHandlerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExceptionHandlerController2 {
    private final ExceptionHandlerServiceImpl service;

    @GetMapping("/v2")
    public ResponseEntity playNullPointException(){
        return new ResponseEntity<>(service.nullPointExceptionError(), HttpStatus.OK);
    }


    @GetMapping("/v2/sample")
    public ResponseEntity playSampleException(){
        return new ResponseEntity<>(service.sampleException(), HttpStatus.OK);
    }

    @ExceptionHandler({NullPointException.class, SampleException.class})
    public String nullPointExceptionHandler(){
        return "Null 또는 SampleException 에러 발생";
    }
}
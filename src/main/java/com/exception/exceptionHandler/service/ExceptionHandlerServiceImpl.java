package com.exception.exceptionHandler.service;

import com.exception.exceptionHandler.dto.SampleDto;
import com.exception.exceptionHandler.exception.NullPointException;
import com.exception.exceptionHandler.exception.SampleException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlerServiceImpl implements ExceptionHandlerService{

    @Override
    public SampleDto nullPointExceptionError() {
        throw new NullPointException("NullPointException 발생");
    }

    @Override
    public SampleDto sampleException() {
        throw new SampleException("SampleException 발생");
    }
}
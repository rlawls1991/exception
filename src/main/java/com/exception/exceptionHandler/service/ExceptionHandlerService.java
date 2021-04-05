package com.exception.exceptionHandler.service;

import com.exception.exceptionHandler.dto.SampleDto;

public interface ExceptionHandlerService {
    SampleDto nullPointExceptionError();
    SampleDto sampleException();
}

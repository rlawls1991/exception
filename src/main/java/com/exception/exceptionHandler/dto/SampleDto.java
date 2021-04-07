package com.exception.exceptionHandler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SampleDto {
    private String name;
    private String nicName;
}

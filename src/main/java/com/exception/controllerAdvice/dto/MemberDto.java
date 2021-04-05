package com.exception.controllerAdvice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class MemberDto {
    @NotEmpty(message = "이름은 null 또는 공백이 들어갈 수 없습니다.")
    private String name;
    @NotEmpty(message = "닉네임은 null 또는 공백이 들어갈 수 없습니다.")
    private String nicName;
    @Email(message = "Email의 형식을 가져야 합니다.")
    private String email;
    @Min(value = 1, message = "1보다 큰 값을 입력해야 합니다.")
    private int agee;
}

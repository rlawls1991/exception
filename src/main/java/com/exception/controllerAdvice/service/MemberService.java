package com.exception.controllerAdvice.service;

import com.exception.controllerAdvice.dto.MemberDto;

public interface MemberService {

    /**
     * Member 생성
     * @param memberDto
     * @return
     */
    MemberDto createMember(MemberDto memberDto);

    /**
     * Member 데이터 가져오기
     * @param memberDto
     * @return
     */
    MemberDto updateMember(MemberDto memberDto);
}

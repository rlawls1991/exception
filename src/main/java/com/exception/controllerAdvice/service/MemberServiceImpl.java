package com.exception.controllerAdvice.service;

import com.exception.controllerAdvice.dto.MemberDto;
import com.exception.controllerAdvice.error.ErrorCode;
import com.exception.controllerAdvice.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Override
    public MemberDto createMember(MemberDto memberDto) {
        throw new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND.getMessage());
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto) {
        return null;
    }
}

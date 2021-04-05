package com.exception.controllerAdvice.controller;


import com.exception.controllerAdvice.dto.MemberDto;
import com.exception.controllerAdvice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/advice")
public class AdviceController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity getMember(@Valid @RequestBody MemberDto dto) {
        return new ResponseEntity<>(memberService.createMember(dto), HttpStatus.OK);
    }
}

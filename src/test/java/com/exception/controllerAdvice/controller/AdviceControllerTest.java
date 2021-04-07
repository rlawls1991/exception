package com.exception.controllerAdvice.controller;

import com.exception.controllerAdvice.dto.MemberDto;
import com.exception.controllerAdvice.error.ErrorCode;
import com.exception.exceptionHandler.dto.SampleDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("입력 받을 수 없는 값을 사욯 한 경우에 에러가 발생하는 테스트")
    void createMember403() throws Exception {
        TestDto testDto = new TestDto("test1", "test2");

        ResultActions perform = mockMvc.perform(post("/advice")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testDto)))
                .andDo(print());

        perform.andExpect(status().is4xxClientError())
                .andExpect(jsonPath("message").value(ErrorCode.PARAMETER_BIND_ERROR.getMessage()))
                .andExpect(jsonPath("status").value(ErrorCode.PARAMETER_BIND_ERROR.getStatus()))
                .andExpect(jsonPath("code").value(ErrorCode.PARAMETER_BIND_ERROR.getCode()))
                .andDo(print());
    }

    @Test
    @DisplayName("입력값이 비어있는 경우 에러가 발생하는 테스")
    void createMember_Bad_Request_Empty_Input() throws Exception {
        // Given
        MemberDto memberDto = MemberDto.builder().build();

        // When
        ResultActions perform = mockMvc.perform(post("/advice")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(memberDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest())
                .andExpect(jsonPath("message").value(ErrorCode.INVALID_INPUT_VALUE.getMessage()))
                .andExpect(jsonPath("status").value(ErrorCode.INVALID_INPUT_VALUE.getStatus()))
                .andExpect(jsonPath("code").value(ErrorCode.INVALID_INPUT_VALUE.getCode()))
                .andDo(print());
    }

    @Test
    @DisplayName("입력값이 잘못들어갔을 경우 에러가 발생하는 테스")
    void createMember_Bad_Request_Wrong_Input() throws Exception {
        // Given
        MemberDto memberDto = MemberDto.builder()
                .age(-1)
                .email("1000")
                .name("")
                .nicName("")
                .build();

        // When
        ResultActions perform = mockMvc.perform(post("/advice")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(memberDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest())
                .andExpect(jsonPath("message").value(ErrorCode.INVALID_INPUT_VALUE.getMessage()))
                .andExpect(jsonPath("status").value(ErrorCode.INVALID_INPUT_VALUE.getStatus()))
                .andExpect(jsonPath("code").value(ErrorCode.INVALID_INPUT_VALUE.getCode()))
                .andDo(print());
    }


    @Test
    @DisplayName("입력값이 잘못들어갔을 경우 에러가 발생하는 테스트")
    void createMember_Bad_Request_Http_Method() throws Exception {
        // Given
        MemberDto memberDto = MemberDto.builder()
                .age(-1)
                .email("1000")
                .name("")
                .nicName("")
                .build();

        // When
        ResultActions perform = mockMvc.perform(delete("/advice")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(memberDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isMethodNotAllowed())
                .andExpect(jsonPath("message").value(ErrorCode.METHOD_NOT_ALLOWED.getMessage()))
                .andExpect(jsonPath("status").value(ErrorCode.METHOD_NOT_ALLOWED.getStatus()))
                .andExpect(jsonPath("code").value(ErrorCode.METHOD_NOT_ALLOWED.getCode()))
                .andDo(print());
    }


    @Test
    @DisplayName("비지니스 에러가 발생하는 테스트")
    void createMember_EntityNotFoundException() throws Exception {
        // Given
        MemberDto memberDto = MemberDto.builder()
                .age(31)
                .email("test@naver.com")
                .name("테스트이름")
                .nicName("닉네임")
                .build();

        // When
        ResultActions perform = mockMvc.perform(post("/advice")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(memberDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().is4xxClientError())
                .andExpect(jsonPath("message").value(ErrorCode.ENTITY_NOT_FOUND.getMessage()))
                .andExpect(jsonPath("status").value(ErrorCode.ENTITY_NOT_FOUND.getStatus()))
                .andExpect(jsonPath("code").value(ErrorCode.ENTITY_NOT_FOUND.getCode()))
                .andDo(print());
    }

    static class TestDto{
        String test1;
        String test2;

        private TestDto(){

        }

        public TestDto(String test1, String test2) {
            this.test1 = test1;
            this.test2 = test2;
        }

        public String getTest1() {
            return test1;
        }

        public String getTest2() {
            return test2;
        }
    }
}
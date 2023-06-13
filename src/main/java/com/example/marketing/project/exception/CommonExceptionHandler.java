package com.example.marketing.project.exception;

import com.example.marketing.global.ResponseDTO;
import com.example.marketing.project.global.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseDTO> handleNoSuchElementException(NoSuchElementException exception) {
        log.error(exception.getMessage());
        Map<String, String> response = toErrorResponse(ResponseCodeEnum.BAD_REQUEST.getCode(), exception.getMessage(),ResponseCodeEnum.BAD_REQUEST.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDTO.ok(response));
    }

    private Map<String,String> toErrorResponse(String code, String message, String exception){
        Map<String,String> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        response.put("error", exception);
        return response;
    }
}

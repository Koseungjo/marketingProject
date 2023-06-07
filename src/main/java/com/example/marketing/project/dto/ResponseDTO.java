package com.example.marketing.project.dto;

import com.example.marketing.project.global.ResponseCodeEnum;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ResponseDTO<T> {
    private Map<String, String> status;
    private T data;

    private ResponseDTO(Map<String,String> status, T data) {
        this.status = status;
        this.data = data;
    }

    private ResponseDTO(Map<String,String> status) {
       this.status = status;
    }

    public static <T> ResponseDTO<T> ok(T data) {
        Map<String,String> status = createSuccessStatus();
        return new ResponseDTO<>(status, data);
    }

    public static <T> ResponseDTO<T> ok(Map<String, String> status) {
        return new ResponseDTO<>(status);
    }

    private static Map<String, String> createSuccessStatus(){
        Map<String,String> status = new HashMap<>();
        status.put("code", ResponseCodeEnum.OK.getCode());
        status.put("message", ResponseCodeEnum.OK.getMessage());
        return status;
    }
}

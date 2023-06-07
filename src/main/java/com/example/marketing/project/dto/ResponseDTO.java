package com.example.marketing.project.dto;

import lombok.Getter;

@Getter
public class ResponseDTO<T> {
    private String code;
    private String message;
    private T data;

    public ResponseDTO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseDTO<T> success(String code, String message, T data) {
        return new ResponseDTO<>(code, message, data);
    }

    public static <T> ResponseDTO<T> fail(String code, String message) {
        return new ResponseDTO<>(code, message);

    }
}

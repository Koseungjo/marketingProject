package com.example.marketing.project.global;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {
    // 1xx Informational
    CONTINUE("100", "Continue"),
    SWITCHING_PROTOCOLS("101", "Switching Protocols"),
    PROCESSING("102", "Processing"),

    // 2xx Success
    OK("200", "OK"),
    CREATED("201", "Created"),
    ACCEPTED("202", "Accepted"),
    NO_CONTENT("204", "No Content"),

    // 3xx Redirection
    MOVED_PERMANENTLY("301", "Moved Permanently"),
    FOUND("302", "Found"),
    SEE_OTHER("303", "See Other"),
    NOT_MODIFIED("304", "Not Modified"),

    // 4xx Client Errors
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),

    // 5xx Server Errors
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
    NOT_IMPLEMENTED("501", "Not Implemented"),
    SERVICE_UNAVAILABLE("503", "Service Unavailable");

    private final String code;
    private final String message;


    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}

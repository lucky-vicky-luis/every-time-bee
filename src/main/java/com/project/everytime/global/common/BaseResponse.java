package com.project.everytime.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseResponse {

    private HttpStatus httpStatus;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public BaseResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public BaseResponse(HttpStatus httpStatus, String message, Object data){
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse ok(String message) {
        return new BaseResponse(HttpStatus.OK, message);
    }

    public static BaseResponse ok(String message, Object data) {
        return new BaseResponse(HttpStatus.OK, message, data);
    }

    public static BaseResponse created(String message) {
        return new BaseResponse(HttpStatus.CREATED, message);
    }

    public static BaseResponse created(String message, Object data) {
        return new BaseResponse(HttpStatus.CREATED, message, data);
    }
}

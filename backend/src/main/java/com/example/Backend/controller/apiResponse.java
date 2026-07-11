package com.example.Backend.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class apiResponse<T> {


    private boolean success;
    private T data;
    private String message;
    private String error;
    private Integer statusCode;

    public static <T> apiResponse<T> ok(T data, String message) {
        return apiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .statusCode(200)
                .build();
    }

    public static <T> apiResponse<T> created(T data, String message) {
        return apiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .statusCode(201)
                .build();
    }

    public static <T> apiResponse<T> error(int statusCode, String error) {
        return apiResponse.<T>builder()
                .success(false)
                .error(error)
                .statusCode(statusCode)
                .build();
    }
}

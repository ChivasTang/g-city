package com.g.city.controller.result;

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private String message;
    private T data;

    private long timestamp;

    public ApiResult() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> ApiResult = new ApiResult<>();
        ApiResult.setCode(ResultCode.RC100.getCode());
        ApiResult.setMessage(ResultCode.RC100.getMessage());
        ApiResult.setData(data);
        return ApiResult;
    }

    public static <T> ApiResult<T> success(ResultCode resultCode, T data) {
        ApiResult<T> ApiResult = new ApiResult<>();
        ApiResult.setCode(resultCode.getCode());
        ApiResult.setMessage(resultCode.getMessage());
        ApiResult.setData(data);
        return ApiResult;
    }

    public static <T> ApiResult<T> fail(ResultCode resultCode) {
        ApiResult<T> ApiResult = new ApiResult<>();
        ApiResult.setCode(resultCode.getCode());
        ApiResult.setMessage(resultCode.getMessage());
        return ApiResult;
    }
}

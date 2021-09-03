package com.bangbangtu.couponscore.utils;

import com.bangbangtu.couponscore.constant.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 公用 Result 返回类
 *
 * @author Administrator
 */
@Getter
@Setter
public class Result<T> {
    private int code;
    private String message;
    private T result;

    public Result(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> Result<T> create(int code, String message, T data) {
        return new Result<T>(code, message, data);
    }

    public static Result<Object> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return create(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static Result<Object> error() {
        return error(null);
    }

    public static <T> Result<T> error(T data) {
        return error(ResultCodeEnum.ERROR.getMessage(), data);
    }

    public static <T> Result<T> error(String message, T data) {
        return create(ResultCodeEnum.ERROR.getCode(), message, data);
    }
}

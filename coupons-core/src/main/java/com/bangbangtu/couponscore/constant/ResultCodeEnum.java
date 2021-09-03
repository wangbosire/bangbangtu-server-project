package com.bangbangtu.couponscore.constant;

import lombok.Getter;

/**
 * 公用返回状态枚举
 *
 * @author Administrator
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器异常"),
    ;

    private int code;
    private String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.bangbangtu.couponscore.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务层异常
 *
 * @author Administrator
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 错误信息
     */
    protected String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }
}

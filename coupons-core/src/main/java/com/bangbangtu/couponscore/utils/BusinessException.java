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
        this.message = message;
    }

    public BusinessException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public BusinessException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public BusinessException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}

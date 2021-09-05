package com.bangbangtu.couponsserver.config;

import com.bangbangtu.couponscore.constant.ResultCodeEnum;
import com.bangbangtu.couponscore.utils.BusinessException;
import com.bangbangtu.couponscore.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


/**
 * 全局异常处理
 *
 * @author Administrator
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务层异常
     **/
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result<Object> uploadException(BusinessException e) {
        logger.error("业务异常！原因是:", e);
        return Result.error(e.getMessage());
    }

    /**
     * 文件超出大小异常
     **/
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public Result<Object> uploadException(MaxUploadSizeExceededException e) {
        logger.error("文件大小超出限制！原因是:", e);
        return Result.error(e.getMessage());
    }

    /**
     * 空指针异常
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result<Object> nullPointerException(NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return Result.error(ResultCodeEnum.ERROR.getMessage());
    }

    /**
     * 未知异常
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> exception(NullPointerException e) {
        logger.error("不可知的异常！原因是:", e);
        return Result.error(e.getMessage());
    }

}

package com.bangbangtu.couponsserver.controller;

import com.bangbangtu.couponscore.utils.BusinessException;
import com.bangbangtu.couponscore.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * 用户 Controller
 *
 * @author Administrator
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public Result<Object> login() {
        throw new BusinessException("业务异常");
    }
}

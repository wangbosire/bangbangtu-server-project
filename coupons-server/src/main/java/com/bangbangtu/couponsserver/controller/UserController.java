package com.bangbangtu.couponsserver.controller;

import com.bangbangtu.couponscore.utils.BusinessException;
import com.bangbangtu.couponscore.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 Controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping(value = "/login")
    public Result<Object> login() {
        throw new BusinessException("业务异常");
    }
}

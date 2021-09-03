package com.bangbangtu.couponsserver.controller;

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
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Result<Object> login() {
        return Result.success();
    }
}

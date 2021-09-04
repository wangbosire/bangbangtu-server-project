package com.bangbangtu.couponsserver.controller;

import com.bangbangtu.couponscore.utils.Result;
import com.bangbangtu.couponsserver.service.impl.WeChatServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 微信接口相关
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Resource
    WeChatServiceImpl weChatService;

    /**
     * 微信授权
     */
    @GetMapping(value = "/auth")
    public Result<Object> auth(@RequestParam String code) {
        return weChatService.auth(code);
    }


}

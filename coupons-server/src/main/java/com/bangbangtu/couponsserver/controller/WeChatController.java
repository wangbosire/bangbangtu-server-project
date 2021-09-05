package com.bangbangtu.couponsserver.controller;

import com.bangbangtu.couponscore.utils.Result;
import com.bangbangtu.couponsserver.service.impl.WeChatServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 微信接口相关
 *
 * @author Administrator
 */
@Api(tags = "微信相关接口")
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Resource
    WeChatServiceImpl weChatService;

    /**
     * 微信授权
     */
    @ApiOperation(value = "微信小程序授权")
    @GetMapping(value = "/auth")
    public Result<Object> auth(
            @RequestParam String code
    ) {
        return weChatService.auth(code);
    }

}

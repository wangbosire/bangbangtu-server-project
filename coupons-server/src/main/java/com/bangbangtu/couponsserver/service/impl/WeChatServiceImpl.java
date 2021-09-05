package com.bangbangtu.couponsserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bangbangtu.couponscore.utils.Result;
import com.bangbangtu.couponsserver.common.HttpClientUtil;
import com.bangbangtu.couponsserver.service.WeChatService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信相关 Service 实现类
 *
 * @author Administrator
 */
@PropertySource("classpath:wechat.yml")
@Service(value = "WeChatService")
public class WeChatServiceImpl implements WeChatService {
    private static final Logger logger = LoggerFactory.getLogger(WeChatServiceImpl.class);

    /**
     * 小程序 appId
     */
    @Value("${appId}")
    private String appId;

    /**
     * 小程序 appSecret
     */
    @Value("${appSecret}")
    private String appSecret;

    /**
     * 小程序授权类型
     */
    @Value("${grantType}")
    private String grantType;

    /**
     * 微信基础接口
     */
    private final String wechatApi = "https://open.weixin.qq.com";

    /**
     * 微信授权接口
     */
    private final String wechatAuthApi = wechatApi + "/sns/jscode2session";

    /**
     * 微信授权接口
     *
     * @param code 小程序用于授权的Code { String }
     * @return { Object }
     */
    @SneakyThrows
    @Override
    public Result<Object> auth(String code) {
        Map<String, String> params = new HashMap<>(4);
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("js_code", code);
        params.put("grant_type", grantType);
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        ResponseEntity<String> result = httpClientUtil.get(wechatAuthApi, String.class, params);
        return Result.success(result.getBody());
    }
}

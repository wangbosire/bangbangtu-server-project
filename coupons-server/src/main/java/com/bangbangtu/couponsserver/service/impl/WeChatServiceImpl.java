package com.bangbangtu.couponsserver.service.impl;

import com.bangbangtu.couponscore.utils.Result;
import com.bangbangtu.couponsserver.common.HttpClientUtil;
import com.bangbangtu.couponsserver.common.JsonUtils;
import com.bangbangtu.couponsserver.service.WeChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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

    /**
     * 小程序 appId
     */
    @Value("appId")
    private String appId;

    /**
     * 小程序 appSecret
     */
    @Value("appSecret")
    private String appSecret;

    /**
     * 小程序授权类型
     */
    @Value("grantType")
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
    @Override
    public Result<Object> auth(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", appId);
        param.put("secret", appSecret);
        param.put("js_code", code);
        param.put("grant_type", grantType);
        String result = HttpClientUtil.get(wechatAuthApi, param);
        return Result.success(JsonUtils.parseObject(result));
    }
}

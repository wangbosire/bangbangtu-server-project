package com.bangbangtu.couponsserver.service;

/**
 * 微信相关 Service
 *
 * @author Administrator
 */
public interface WeChatService {
    /**
     * 微信授权
     *
     * @param code { String }
     * @return { Object }
     */
    Object auth(String code);
}

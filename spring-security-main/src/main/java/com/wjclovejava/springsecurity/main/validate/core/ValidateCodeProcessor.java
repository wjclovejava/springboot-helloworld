package com.wjclovejava.springsecurity.main.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: wjc
 * @Description: 校验码处理器.封装不同的处理逻辑
 * @Date: created in 2019/1/23 16:28
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX="SESSION_KEY_FOR_CODE_";

    /**
     *  创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}

package com.wjclovejava.springsecurity.main.properties;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 20:16
 */
public interface SecurityConstants {
    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX="/code";
    /**
     * 需要身份验证时,默认跳转的url
     */
    String DEFAULT_UNAUTHENTICATION_URL="/authentication/require";
    /**
     * 默认的用户密码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM="/authentication/form";
    /**
     * 默认的手机登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE="/authentication/mobile";
    /**
     * 默认的登录页面
     */
    String DEFAULT_LOGIN_PAGE_URL="/login.html";
    /**
     * 验证图片验证时,http请求中默认的携带图片验证码信息的参数名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE="imageCode";
    /**
     * 验证短信验证时,http请求中默认的携带短信验证码信息的参数名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS="smsCode";

    /**
     * 发送短信验证码或者验证短信验证码时,传递 手机号 参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE="mobile";
}

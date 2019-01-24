package com.wjclovejava.springsecurity.main.validate.core.sms;

/**
 * @Author: wjc
 * @Description: 短信发送接口
 * @Date: created in 2019/1/23 15:27
 */
public interface SmsCodeSender {

    void send(String mobile , String code);
}

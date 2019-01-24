package com.wjclovejava.springsecurity.main.validate.core.sms;

import org.springframework.stereotype.Service;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 15:27
 */
@Service
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号"+mobile+"发送短信验证码:"+code);
    }
}

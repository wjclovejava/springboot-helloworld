package com.wjclovejava.springsecurity.main.properties;

import lombok.Data;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 11:15
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image=new ImageCodeProperties();

    private SmsCodeProperties sms=new SmsCodeProperties();
}

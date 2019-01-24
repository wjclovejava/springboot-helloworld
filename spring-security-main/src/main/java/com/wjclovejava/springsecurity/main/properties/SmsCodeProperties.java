package com.wjclovejava.springsecurity.main.properties;

import lombok.Data;

/**
 * @Author: wjc
 * @Description: 图形验证码配置
 * @Date: created in 2019/1/23 11:13
 */
@Data
public class SmsCodeProperties {

    private int length=6;
    private int expireIn=60;

    private String url;

}

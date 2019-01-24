package com.wjclovejava.springsecurity.main.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wjc
 * @Description: 图形验证码配置
 * @Date: created in 2019/1/23 11:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCodeProperties extends SmsCodeProperties {

    private int width=67;
    private int height=23;

    /**
     * 默认4位
     */
    public ImageCodeProperties() {
        setLength(4);
    }
}

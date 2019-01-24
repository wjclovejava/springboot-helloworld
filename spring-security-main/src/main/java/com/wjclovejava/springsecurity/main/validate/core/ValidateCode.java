package com.wjclovejava.springsecurity.main.validate.core;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: wjc
 * @Description: 短信验证码
 * @Date: created in 2019/1/23 9:16
 */
@Data
public class ValidateCode {

    protected String code;
    protected LocalDateTime expireTime;

    /**
     * 是否过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, int expireTime) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

}

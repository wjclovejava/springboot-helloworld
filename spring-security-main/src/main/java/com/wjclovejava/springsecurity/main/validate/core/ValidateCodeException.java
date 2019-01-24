package com.wjclovejava.springsecurity.main.validate.core;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 10:30
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg) {
        super(msg);
    }
}

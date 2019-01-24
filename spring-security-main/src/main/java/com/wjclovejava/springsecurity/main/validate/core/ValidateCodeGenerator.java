package com.wjclovejava.springsecurity.main.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: wjc
 * @Description: 验证码生成器
 * @Date: created in 2019/1/23 14:26
 */
public interface ValidateCodeGenerator {

     ValidateCode generate(ServletWebRequest request);
}

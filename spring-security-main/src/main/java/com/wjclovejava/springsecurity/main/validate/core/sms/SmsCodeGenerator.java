package com.wjclovejava.springsecurity.main.validate.core.sms;

import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
import com.wjclovejava.springsecurity.main.validate.core.ValidateCode;
import com.wjclovejava.springsecurity.main.validate.core.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 15:37
 */
@Component("smsValidateCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code=RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }
}

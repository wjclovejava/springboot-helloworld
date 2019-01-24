package com.wjclovejava.springsecurity.main.validate.core.sms;

import com.wjclovejava.springsecurity.main.properties.SecurityConstants;
import com.wjclovejava.springsecurity.main.validate.core.impl.AbstractValidateCodeProcessor;
import com.wjclovejava.springsecurity.main.validate.core.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 16:39
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;
    /**
     * 发送短信验证码
     * @param request
     * @return
     */
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile =ServletRequestUtils.getRequiredStringParameter(request.getRequest(), SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE);
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}

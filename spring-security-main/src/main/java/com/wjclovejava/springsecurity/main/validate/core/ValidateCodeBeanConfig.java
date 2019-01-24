package com.wjclovejava.springsecurity.main.validate.core;

import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
import com.wjclovejava.springsecurity.main.validate.core.image.ImageCodeGenerator;
import com.wjclovejava.springsecurity.main.validate.core.sms.DefaultSmsCodeSender;
import com.wjclovejava.springsecurity.main.validate.core.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 14:32
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;


    /**
     *  如果不加 @ConditionalOnMissingBean 和在ImageCodeGenerator类上加@Component 是一样的
     *  @ConditionalOnMissingBean 表示初始化这个bean之前会去查找 名为imageCodeGenerator 的 bean,找得到就用找到的bean,找不到会加载这个bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name="imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator(){
        ImageCodeGenerator codeGenerator=new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    /**
     *  如果不加 @ConditionalOnMissingBean 和在ImageCodeGenerator类上加@Component 是一样的
     *  @ConditionalOnMissingBean 表示初始化这个bean之前会去查找 名为imageCodeGenerator 的 bean,找得到就用找到的bean,找不到会加载这个bean
     * @return
     */
    @Bean
    //@ConditionalOnMissingBean(name="smsCodeSender")
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeGenerator(){
        return new DefaultSmsCodeSender();
    }
}

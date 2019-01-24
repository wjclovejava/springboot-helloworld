package com.wjclovejava.springsecurity.main;

import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wjc
 * @Description:  作用:让 SecurityProperties 生效
 * @Date: created in 2019/1/22 16:09
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}

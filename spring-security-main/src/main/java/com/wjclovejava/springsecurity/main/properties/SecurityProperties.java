package com.wjclovejava.springsecurity.main.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: wjc
 * @Description: 安全配置
 * @Date: created in 2019/1/22 15:58
 */
@Data
@ConfigurationProperties(prefix ="wjclovejava.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();
}

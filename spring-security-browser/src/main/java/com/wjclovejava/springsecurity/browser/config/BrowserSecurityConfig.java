package com.wjclovejava.springsecurity.browser.config;

import com.wjclovejava.springsecurity.main.properties.SecurityConstants;
import com.wjclovejava.springsecurity.main.authentication.AbstractChannelSecurityConfig;
import com.wjclovejava.springsecurity.main.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
//import com.wjclovejava.springsecurity.main.validate.core.ValidateCodeSecurityConfig;
import com.wjclovejava.springsecurity.main.validate.core.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/21 20:48
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        applyPasswordAuthenticationConfig(http);

            http.apply(smsCodeAuthenticationSecurityConfig)
                    .and()
                    .apply(validateCodeSecurityConfig)
                    .and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                .authorizeRequests()
                    .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                            SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                                securityProperties.getBrowser().getLoginPage(),
                            SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .csrf()
                .disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository=new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //执行一次就可以注掉了自动在数据库生成token表
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}

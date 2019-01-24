package com.wjclovejava.springsecurity.main.authentication.mobile;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: wjc
 * @Description: 短信认证提供器
 * @Date: created in 2019/1/23 17:51
 */
@Data
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken=(SmsCodeAuthenticationToken)authentication;
        UserDetails user=  userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if(user==null){
            throw  new InternalAuthenticationServiceException("无法获取用户信息");
        }
        SmsCodeAuthenticationToken authenticationResult=new SmsCodeAuthenticationToken(user, user.getAuthorities());
        //将未认证token的信息copy到已认证的token中
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        //判断是不是SmsCodeAuthentication类型
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

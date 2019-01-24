package com.wjclovejava.springsecurity.browser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjclovejava.springsecurity.main.properties.LoginType;
import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/22 19:52
 */
@Component("authSuccessHandler")
public class AuthSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger=LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    SecurityProperties securityProperties;
    /**
     * 登录成功调用此方法
     * @param request
     * @param response
     * @param authentication 认证信息(ip.session.用户信息等..)
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");
        //如果返回类型是json,转换成json返回,否则调用父类方法,默认跳转
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}

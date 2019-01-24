package com.wjclovejava.springsecurity.browser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjclovejava.springsecurity.main.properties.LoginType;
import com.wjclovejava.springsecurity.main.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/22 20:01
 */
@Component("authFailHandler")
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger=LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    SecurityProperties securityProperties;
    /**
     * 登录失败调用此方法
     * @param request
     * @param response
     * @param exception 认证过程中产生的异常
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");

        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
        }else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}

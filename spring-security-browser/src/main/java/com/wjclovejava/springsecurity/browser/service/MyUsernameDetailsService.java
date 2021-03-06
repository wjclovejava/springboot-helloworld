package com.wjclovejava.springsecurity.browser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/22 15:01
 */
@Component
public class MyUsernameDetailsService implements UserDetailsService {

    private Logger logger=LoggerFactory.getLogger(MyUsernameDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名"+username);
        //根据用户名查询用户信息
        //根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是"+password);
        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

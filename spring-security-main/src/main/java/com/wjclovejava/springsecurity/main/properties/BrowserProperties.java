package com.wjclovejava.springsecurity.main.properties;

import lombok.Data;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/22 15:58
 */
@Data
public class BrowserProperties {

    private String loginPage=SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginType loginType=LoginType.JSON;
    /**
     * 记住我 7天
     */
    private int rememberMeSeconds =3600*24*7;
}

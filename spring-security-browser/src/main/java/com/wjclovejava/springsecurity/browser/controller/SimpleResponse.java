package com.wjclovejava.springsecurity.browser.controller;

import lombok.Data;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/22 15:50
 */
@Data
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }


}

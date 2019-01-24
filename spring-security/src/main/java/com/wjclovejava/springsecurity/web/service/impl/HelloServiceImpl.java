package com.wjclovejava.springsecurity.web.service.impl;

import com.wjclovejava.springsecurity.web.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/21 10:58
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello"+name;
    }
}

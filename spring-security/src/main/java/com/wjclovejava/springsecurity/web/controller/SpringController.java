package com.wjclovejava.springsecurity.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/18 16:22
 */
@RestController
@RequestMapping("/user")
public class SpringController {

    /**
     * 创建
     * @param userDTO
     * @return
     */
    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO userDTO){

        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getPassword());
        System.out.println(userDTO.getId());
        System.out.println(userDTO.getBirthday());
        userDTO.setId("1");
        return userDTO;
    }

    /**
     * 修改
     * @param userDTO
     * @return
     */
    @PutMapping
    public UserDTO update(@Valid @RequestBody UserDTO userDTO){
        return userDTO;
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Integer id){
        System.out.println(id);
    }

    /**
     *            :\\d+  正则表示数字
     */
    @GetMapping("/{id:\\d+}")
    public UserDTO userInfo(@PathVariable String id){

        System.out.println("进入getInfo服务");
        UserDTO userDTO=new UserDTO();
        userDTO.setUsername("Tom");
        return userDTO;
    }

    /**
     * 获取当前用户信息
     * @return
     */
    @GetMapping
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }

}

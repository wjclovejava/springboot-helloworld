package com.wjclovejava.springsecurity.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wjclovejava.springsecurity.web.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/18 16:53
 */
public class UserDTO {

    private String id;

    @MyConstraint(message = "这是一个测试")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "必须是过去的时间")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 定义简单对象返回视图
     */
    public interface UserSimpleView{};

    /**
     * 定义详细对象返回视图 继承简单视图
     */
    public interface UserDetailView  extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

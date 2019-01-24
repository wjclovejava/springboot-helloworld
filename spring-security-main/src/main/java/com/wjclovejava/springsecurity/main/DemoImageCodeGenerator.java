package com.wjclovejava.springsecurity.main;

import com.wjclovejava.springsecurity.main.validate.core.image.ImageCode;
import com.wjclovejava.springsecurity.main.validate.core.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: wjc
 * @Description:  以增量的方式适应变化
 * @Date: created in 2019/1/23 14:39
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}

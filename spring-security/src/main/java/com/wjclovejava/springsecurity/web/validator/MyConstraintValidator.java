package com.wjclovejava.springsecurity.web.validator;

import com.wjclovejava.springsecurity.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/21 10:46
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    /**
     * 初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("MyConstraintValidator init");
    }

    /**
     * 校验规则
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        helloService.greeting("tom");

        System.out.println(value);

        return true;
    }
}

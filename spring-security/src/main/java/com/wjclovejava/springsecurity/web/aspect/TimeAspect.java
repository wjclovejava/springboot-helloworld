package com.wjclovejava.springsecurity.web.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: wjc
 * @Description: 切片
 * @Date: created in 2019/1/21 15:45
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.wjclovejava.springsecurity.web.controller.*.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("TimeAspect start");
        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            System.out.println("arg is"+arg);
        }
        long start=System.currentTimeMillis();

        Object object=joinPoint.proceed();

        System.out.println("TimeAspect 耗时:"+(System.currentTimeMillis()-start));

        System.out.println("TimeAspect end");

        return object;
    }

}

package com.moontwon.demo.aspectj.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/31
 */
@Aspect
public class UserTracing {
    @Before("execution(public * com.moontwon.demo.aspectj.service..UserService+.login(..))  && args(username,..)")
    public void login(String username) {
        System.err.println("UserTracing " + username + "要登录");
    }
}

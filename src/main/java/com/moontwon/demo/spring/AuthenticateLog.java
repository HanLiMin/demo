package com.moontwon.demo.spring;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AuthenticateLog {

	@Pointcut(value = "execution(public * com.moontwon.spring.AuthenticateService.login(..)) && args(name,..)")
	public void login(String name) {
	}
	@AfterReturning(value = "login(name)", returning = "r")
	public void log(JoinPoint joinPoint,String name, boolean r) {
		System.err.println(Arrays.toString(joinPoint.getArgs()));
		if (r) {
			System.err.println(name + " 登陆成功 ");
		} else {
			System.err.println(name + " 登陆失败 ");
		}

	}
}

package com.moontwon.demo.java.proxy;

import com.moontwon.demo.java.service.BookService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-3
 */
public class BookServiceDyProxy implements InvocationHandler {
    private Object object;

    public BookServiceDyProxy(Object object) {
        this.object = object;
    }

    public BookService getProxy() {
        return (BookService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("动态代理开始");
        Object ret = method.invoke(object, args);
        System.err.println("动态代理结束");
        return ret;
    }
}

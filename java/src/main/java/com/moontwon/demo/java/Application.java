package com.moontwon.demo.java;

import com.moontwon.demo.java.proxy.BookServiceDyProxy;
import com.moontwon.demo.java.proxy.BookServiceProxy;
import com.moontwon.demo.java.service.BookService;
import com.moontwon.demo.java.service.impl.BookServiceImpl;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-2
 */
public class Application {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        System.err.println(bookService.getPrice(45));


        BookServiceProxy bookServiceProxy = new BookServiceProxy(bookService);
        System.err.println(bookServiceProxy.getPrice(90));

        BookServiceDyProxy bookServiceDyProxy = new BookServiceDyProxy(bookService);
        System.err.println(bookServiceDyProxy.getProxy().getPrice(100));
    }
}

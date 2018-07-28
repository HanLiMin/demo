package com.moontwon.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
@Service
public class StudentService {
    private BookService bookService;

    public void init() {
        System.err.println("StudentService init method invoken");
    }

    public void destory() {
        System.err.println("StudentService destory method invoken");
    }

    @Autowired
    public StudentService(BookService bookService) {
        this.bookService = bookService;
    }
}

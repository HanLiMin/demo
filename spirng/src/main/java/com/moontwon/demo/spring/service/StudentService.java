package com.moontwon.demo.spring.service;

import lombok.Data;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
@Data
public class StudentService {
    private BookService bookService;

    public void init(){
        System.err.println("StudentService init method invoken");
    }

    public void destory(){
        System.err.println("StudentService destory method invoken");
    }
    public StudentService(BookService bookService) {
        this.bookService = bookService;
    }
}

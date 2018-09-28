package com.moontwon.demo.java.proxy;

import com.moontwon.demo.java.dto.BookDTO;
import com.moontwon.demo.java.service.BookService;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-2
 */
public class BookServiceProxy implements BookService {
    private BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public long getPrice(long id) {
        System.err.println("普通代理");
        return bookService.getPrice(id);
    }

    @Override
    public void print(BookDTO bookDTO) {

    }
}

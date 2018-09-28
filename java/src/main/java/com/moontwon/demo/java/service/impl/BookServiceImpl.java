package com.moontwon.demo.java.service.impl;

import com.moontwon.demo.java.dto.BookDTO;
import com.moontwon.demo.java.service.BookService;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-2
 */
public class BookServiceImpl implements BookService {
    @Override
    public long getPrice(long id) {
        return id;
    }

    @Override
    public void print(BookDTO bookDTO) {
        System.err.println(bookDTO.getName()+":￥"+bookDTO.getPrice());
    }
}

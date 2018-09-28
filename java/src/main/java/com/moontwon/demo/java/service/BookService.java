package com.moontwon.demo.java.service;

import com.moontwon.demo.java.dto.BookDTO;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-2
 */
public interface BookService {
    long getPrice(long id);

    void print(BookDTO bookDTO);
}

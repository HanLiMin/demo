package com.moontwon.demo.java;

import com.moontwon.demo.java.dto.BookDTO;
import com.moontwon.demo.java.service.BookService;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-9-20
 */
public class Store implements BookService {
    private BookService bookService;

    public void setBookService(BookDTO outbookDTO) {
        bookService = new BookService() {
            @Override
            public long getPrice(long id) {
                return 0;
            }

            @Override
            public void print(BookDTO bookDTO) {
//                System.err.println(outbookDTO.getName() + "===============" + outbookDTO.getPrice());
//                System.err.println(outbookDTO.hashCode());
            }
        };
    }

    @Override
    public long getPrice(long id) {
        return 0;
    }

    @Override
    public void print(BookDTO bookDTO) {
        bookService.print(bookDTO);
    }

    public static void main(String[] args) {
        Store store = new Store();
        BookDTO bookDTO = new BookDTO();
        System.err.println(bookDTO.hashCode());
        bookDTO.setName("海底两万里");
        bookDTO.setPrice(56);
        store.setBookService(bookDTO);
        store.print(null);
        store.print(null);
        store.print(null);
        store.print(null);
    }
}

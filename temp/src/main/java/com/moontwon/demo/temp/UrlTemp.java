package com.moontwon.demo.temp;


import java.net.URI;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
public class UrlTemp {
    public static void main(String[] args) {
        String url="http://www.baidu.com/index/query?page=2&size=10";
        URI uri = URI.create(url);
        System.err.println(uri.getQuery());
        System.err.println(uri.getPath());
        System.err.println();
        int i = 1;

    }
}

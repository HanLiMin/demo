package com.moontwon.demo.url;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/27
 */
public class UrlDemo {
    public static void main(String[] args) throws IOException {
//        String www = "http://www.baidu.com/home/index.html?name=admin&password=123456#lo";
        String www = "http://www.baidu.com/http://www.com";
        URL url = new URL(www);
        System.err.println(url.getFile());
        System.err.println(url.toExternalForm());
        System.err.println(url.toString());
        try {
            for (;;) {
                String file = url.getFile();
                System.err.println(file);
                url = new URL(file);
            }
        } catch (MalformedURLException e) {
           e.printStackTrace();
        }
        System.err.println(url.toString());
    }
}

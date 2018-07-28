package com.moontwon.demo.url;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
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
        String www = "http://www.baidu.com";
        URL url = new URL(www);
        InputStream inputStream = url.openStream();
        System.err.println(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
    }
}

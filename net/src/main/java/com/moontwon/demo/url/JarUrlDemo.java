package com.moontwon.demo.url;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/8
 */
public class JarUrlDemo {
    public static void main(String[] args) throws IOException {
//        String name = "org/apache/ibatis/io";
        String name = "java/lang";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<URL> list = Collections.list(classLoader.getResources(name));
        for (URL url : list) {
            System.err.println(url);
        }

    }
}

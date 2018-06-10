package com.moontwon.demo.init;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-5-5
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Enumeration<URL> resources = classLoader.getResources("com/moontwon");
        int i=0;
        while (resources.hasMoreElements()) {
            System.err.println(Integer.toString(i++) + resources.nextElement());
        }
    }
}

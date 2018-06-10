package com.moontwon.java8.test.batis.io;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-5-7
 */
public class DemoTest {
    @Test
    public void testGetResuours() throws IOException {
        String path = "org/dom4j/bean";
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.err.println(url.getFile());
        }
    }

    @Test
    public void testJarPaht() throws IOException, URISyntaxException {
        String path = "org/dom4j/bean/";
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = contextClassLoader.getResources(path);
        URL url = resources.nextElement();
        try {
            for (; ; ) {
                url = new URL(url.getFile());
                System.err.println("===");
            }
        } catch (MalformedURLException e) {
//            e.printStackTrace();
            // This will happen at some point and serves as a break in the loop
        }
        System.err.println(url.toExternalForm());
    }

    @Test
    public void testUrl() throws MalformedURLException {
        URL url = new URL("http://www.moontwon.com/html/index?type=2");
        System.err.println(url.getProtocol());
        System.err.println(url.getHost());
        System.err.println(url.getPort());
        System.err.println(url.getPath());
        System.err.println(url.getFile());
        System.err.println(url.getQuery());
        System.err.println(url.toExternalForm());
    }

    @Test
    public void testClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.err.println(contextClassLoader);
        System.err.println(systemClassLoader);
        System.err.println(contextClassLoader == systemClassLoader);
    }
}

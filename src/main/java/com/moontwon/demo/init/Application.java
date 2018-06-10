package com.moontwon.demo.init;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-5-5
 */
public class Application {
    static {
        System.err.println("application init");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String name = "java.lang.String";
        System.err.println(name.substring(0,name.indexOf('.')));
        Class cl = classLoader.loadClass(name);
        System.err.println(cl.getName());

    }
}

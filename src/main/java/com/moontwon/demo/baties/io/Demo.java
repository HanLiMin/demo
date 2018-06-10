package com.moontwon.demo.baties.io;

import org.apache.ibatis.io.VFS;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-5-7
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        VFS instance = VFS.getInstance();
        List<String> list = instance.list("io/vertx/core/buffer");
        list.forEach(System.out::println);
        URL url = new URL("");
        String a = "";
        long l = 100;
    }
    public void getId(String name,int age){}
    public void getId(int age,String name){}


}

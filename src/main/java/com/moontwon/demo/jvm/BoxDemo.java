package com.moontwon.demo.jvm;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-6-6
 */
public class BoxDemo {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.err.println(c == d);//true
        System.err.println(e == f);//false
        System.err.println(c == (a + b));//true
        System.err.println(c.equals(a + b));//true
        System.err.println(g == (a + b));//false X
        System.err.println(g.equals(a + b));//true X


    }
}

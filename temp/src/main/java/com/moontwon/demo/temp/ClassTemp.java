package com.moontwon.demo.temp;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/28
 */
public class ClassTemp {
    class  A{}
    class  B extends A{}

    public static void main(String[] args) {
        System.err.println(A.class.isAssignableFrom(B.class));
    }
}

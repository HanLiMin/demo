package com.moontwon.demo.jvm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-6-6
 */
public class CastDemo {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList();
        List<String> strings = Lists.newArrayList();
        Class<? extends List> aClass = integers.getClass();
        Class<? extends List> aClass1 = strings.getClass();
        System.err.println(aClass);
        System.err.println(aClass1);
        System.err.println(aClass==aClass1);
        System.err.println(aClass.equals(aClass1));
        System.err.println(aClass.isAssignableFrom(aClass1));
    }
}

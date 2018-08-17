package com.moontwon.demo.java;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-8-17
 */
public class ArrayTest {
    @Test
    public void testForciblyCast(){
        String[] arary = new String[]{"hello", "world"};
        int[] toCastArray = new int[arary.length];
        for (int i = 0; i < arary.length; i++) {
            Array.set(toCastArray, i, arary[i]);
        }
    }

}

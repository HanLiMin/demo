package com.moontwon.demo.java7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/9
 */
public class ClassTest {
    @Test
    public void testIsAssigableFrom() {
        System.err.println(Map.class.isAssignableFrom(HashMap.class));
    }

    @Test
    public void testGenericDeclaration() {
        System.err.println(Arrays.toString(HashMap.class.getTypeParameters()));
    }


}

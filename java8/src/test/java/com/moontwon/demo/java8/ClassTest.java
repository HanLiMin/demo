package com.moontwon.demo.java8;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/9
 */
public class ClassTest {

    @Test
    public void testTypeName() {
        HashMap<String, Long>[] hashMaps = new HashMap[0];
        System.err.println(hashMaps.getClass().getTypeName());
        System.err.println(hashMaps.getClass().getName());
        System.err.println(int.class.getTypeName());
        System.err.println(int.class.getName());
        int[] ints = new int[0];
        System.err.println(ints.getClass().getTypeName());
        System.err.println(ints.getClass().getName());
        System.err.println(hashMaps);

        int[][][] ints1 = new int[0][][];
        System.err.println(ints1);
        List<Integer>[] list = new ArrayList[0];
        System.err.println(list.getClass().getName());

    }
}

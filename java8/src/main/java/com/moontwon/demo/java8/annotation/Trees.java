package com.moontwon.demo.java8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/15
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Trees {
    Tree[] value();
}

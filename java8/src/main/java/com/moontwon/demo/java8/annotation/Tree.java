package com.moontwon.demo.java8.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Trees.class)
public @interface Tree {
}

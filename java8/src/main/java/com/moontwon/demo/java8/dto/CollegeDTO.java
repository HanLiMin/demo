package com.moontwon.demo.java8.dto;

import com.moontwon.demo.java8.annotation.Money;
import com.moontwon.demo.java8.annotation.Tree;
import com.moontwon.demo.java8.annotation.Trees;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/15
 */
@Money
@Trees(value = {
        @Tree,
        @Tree,
        @Tree,
})
public class CollegeDTO extends StudentDTO {
}

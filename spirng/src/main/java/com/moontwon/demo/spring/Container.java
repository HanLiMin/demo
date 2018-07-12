package com.moontwon.demo.spring;

import com.moontwon.demo.spring.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
public class Container {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        StudentService bean = classPathXmlApplicationContext.getBean(StudentService.class);
    }
}

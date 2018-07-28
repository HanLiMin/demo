package com.moontwon.demo.spring;

import com.moontwon.demo.spring.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
public class Container {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ApplicationConfiguration.class);
        annotationConfigApplicationContext.refresh();

        StudentService bean = annotationConfigApplicationContext.getBean(StudentService.class);
        System.err.println(annotationConfigApplicationContext.getBean(Config.class).getAppName());
        System.err.println();
    }
}

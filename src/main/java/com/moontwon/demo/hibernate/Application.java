package com.moontwon.demo.hibernate;

import com.moontwon.demo.hibernate.dao.StudentDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-4
 */

public class Application {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        configApplicationContext.getBean(StudentDAO.class).change(12,"77777777777777777777");
//        configApplicationContext.close();
    }
}

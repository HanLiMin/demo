package com.moontwon.demo.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-10
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.moontwon.demo.hibernate")
public class ApplicationConfiguration implements TransactionManagementConfigurer{
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return jpaTransactionManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("bbb");
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }
}

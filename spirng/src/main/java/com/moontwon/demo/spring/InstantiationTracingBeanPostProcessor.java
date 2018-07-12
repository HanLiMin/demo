package com.moontwon.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessBeforeInitialization :" + bean + "--" + beanName);
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("postProcessAfterInitialization :" + bean + "--" + beanName);
        return bean;
    }
}

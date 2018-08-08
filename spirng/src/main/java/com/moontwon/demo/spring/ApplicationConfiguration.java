package com.moontwon.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/27
 */
@Configuration
@ComponentScan("com.moontwon.demo.spring")
@PropertySource(value = "classpath:/config.properties", encoding = "UTF-8")
public class ApplicationConfiguration {
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        return new ConversionServiceFactoryBean();
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

}

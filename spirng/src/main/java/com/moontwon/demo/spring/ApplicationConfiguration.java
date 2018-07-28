package com.moontwon.demo.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/27
 */
@Configuration
@ComponentScan("com.moontwon.demo.spring")
@PropertySource(value = "classpath:/config.properties",encoding = "UTF-8")
public class ApplicationConfiguration {
}

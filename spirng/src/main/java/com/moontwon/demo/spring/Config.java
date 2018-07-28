package com.moontwon.demo.spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/27
 */
@Component
@Data
public class Config {
    @Value("${app.name}")
    private String appName;
}

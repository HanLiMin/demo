package com.moontwon.demo.spring.listener;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/27
 */
@Component
public class ApplicationStartListener implements org.springframework.context.ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.err.println("监听到事件" + event);
    }
}

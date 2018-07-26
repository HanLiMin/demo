package com.moontwon.demo.spring.service;

import org.springframework.context.Lifecycle;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
public class BookService implements Lifecycle {
    @Override
    public void start() {
        System.err.println("啦啦啦啦啦啦啦啦啦啦来来来绿啦啦啦啦啦啦啦啦啦啦来来来绿");
    }

    @Override
    public void stop() {
        System.err.println("医医医医医医医医医医医医医医医医医医医医医医医医医医医医医医医医");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}

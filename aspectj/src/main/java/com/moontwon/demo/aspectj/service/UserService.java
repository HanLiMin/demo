package com.moontwon.demo.aspectj.service;

import javax.annotation.Resource;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/31
 */
public interface UserService {
    @Resource(description = "啦啦啦啦啦啦啦啦啦啦来来来")
    boolean login(String username, String password);
}

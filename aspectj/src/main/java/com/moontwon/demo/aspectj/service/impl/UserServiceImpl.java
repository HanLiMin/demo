package com.moontwon.demo.aspectj.service.impl;

import com.moontwon.demo.aspectj.service.UserService;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/2
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        System.err.println(username + " 欲登陆");
        return "admin".equals(username) && "123456".equals(password);
    }
}

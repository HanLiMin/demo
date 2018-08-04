package com.moontwon.demo.aspectj;

import com.moontwon.demo.aspectj.service.UserService;
import com.moontwon.demo.aspectj.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/2
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    
    @Test
    public void testLogin(){
        userService.login("admin", "123456");
    }
}

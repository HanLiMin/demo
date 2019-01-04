package com.moontwon.demo.java8;

import netscape.security.PrivilegeTable;
import org.junit.Test;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 19-1-4
 */
public class SecurityTest {
    @Test
    public void securityManagerTest() {
        AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
            System.err.println(123);
            System.err.println(System.getSecurityManager());
            return null;

        });

    }
}

package com.moontwon.demo.java.jmx;

import org.junit.Test;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 19-2-11
 */
public class MServerTest {
    @Test
    public void mServerRun() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException,
            InterruptedException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        Config config = new Config();
        ObjectName aaa = new ObjectName("com.moontwon.demo.java.jmx:type=Config");
        platformMBeanServer.registerMBean(config, aaa);
        Thread.sleep(1000 * 300);

    }




}

package com.moontwon.demo.java.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 19-2-11
 */
public class Config extends NotificationBroadcasterSupport implements ConfigMBean {
    private String name;
    private String level;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        String oldLevel = this.level;
        this.level = level;
        Notification notification = new AttributeChangeNotification(this, 0, System.currentTimeMillis(), "level changed", "level", "string", oldLevel, level);
        sendNotification(notification);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

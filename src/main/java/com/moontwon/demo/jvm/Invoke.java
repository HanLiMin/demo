package com.moontwon.demo.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-6-5
 */
public class Invoke {
    public static void main(String[] args) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class);
        TaskWoker taskWoker = new TaskWoker();
        MethodHandle work = MethodHandles.lookup().findVirtual(TaskWoker.class, "work", methodType).bindTo(taskWoker);
        work.invoke();
    }
}

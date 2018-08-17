package com.moontwon.demo.java8;

import com.moontwon.demo.java8.dto.StudentDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/15
 */
public class ClassloaderTest {
    @Test
    public void testClassAssertionStatus() {
        ClassloaderTest.class.getClassLoader().setPackageAssertionStatus("com.moontwon.demo.java8.dto", true);
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.doSomething();
        System.err.println(StudentDTO.class.getName());
    }

    @Test
    public void testRetrieveDirectives() throws InvocationTargetException, IllegalAccessException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<? extends ClassLoader> contextClassLoaderClass = contextClassLoader.getClass();
        Method retrieveDirectives = null;
        while (true) {
            try {
                retrieveDirectives = contextClassLoaderClass.getDeclaredMethod("retrieveDirectives");
                if (retrieveDirectives != null) {
                    break;
                }
            } catch (NoSuchMethodException e) {
                if ((contextClassLoaderClass = (Class<? extends ClassLoader>) contextClassLoaderClass.getSuperclass()) == null) {
                    break;
                }
            }
        }
        if (retrieveDirectives != null) {
            retrieveDirectives.setAccessible(true);
            Object invoke = retrieveDirectives.invoke(null);
            String string = ToStringBuilder.reflectionToString(invoke, ToStringStyle.JSON_STYLE);
            System.err.println(invoke.getClass().getName() + "\n" + string);
        }

    }
}

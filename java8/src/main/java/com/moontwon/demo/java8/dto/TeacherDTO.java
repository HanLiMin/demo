package com.moontwon.demo.java8.dto;

import java.util.List;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/16
 */
public class TeacherDTO<T> {
    public List<StudentDTO> studentDTOS;
    public T obj;
    public T[] objs;
}

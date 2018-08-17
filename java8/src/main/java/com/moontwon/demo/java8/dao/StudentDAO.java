package com.moontwon.demo.java8.dao;

import com.moontwon.demo.java8.dto.StudentDTO;
import com.moontwon.demo.java8.dto.TeacherDTO;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/16
 */
public interface StudentDAO<T extends StudentDTO, R extends TeacherDTO > {

    void insert(T studentDTO);

    R techer(T studentDTO);
}

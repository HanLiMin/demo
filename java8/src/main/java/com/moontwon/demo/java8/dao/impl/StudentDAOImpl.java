package com.moontwon.demo.java8.dao.impl;

import com.moontwon.demo.java8.dao.StudentDAO;
import com.moontwon.demo.java8.dto.StudentDTO;
import com.moontwon.demo.java8.dto.TeacherDTO;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/16
 */
public class StudentDAOImpl implements StudentDAO<StudentDTO, TeacherDTO> {
    @Override
    public void insert(StudentDTO studentDTO) {
        System.err.println(studentDTO);
    }

    @Override
    public TeacherDTO techer(StudentDTO studentDTO) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.err.println("Hello World");
            }
        };
        return null;
    }
}

package com.moontwon.demo.hibernate.dao;

import com.moontwon.demo.hibernate.bean.Student;

import java.util.List;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-10
 */
public interface StudentDAO {
    String findNameById(long id);
    boolean save(Student student);
    void change(long id,String name);
    List<Student> getAll();
}

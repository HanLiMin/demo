package com.moontwon.demo.hibernate.service;

import com.moontwon.demo.hibernate.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-10
 */
@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public void name(long id){
        System.err.println(studentDAO.findNameById(id));
    }

}

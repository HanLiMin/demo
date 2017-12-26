package com.moontwon.demo.hibernate.dao.impl;

import com.moontwon.demo.hibernate.bean.Student;
import com.moontwon.demo.hibernate.dao.StudentDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-10
 */
@Repository
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String findNameById(long id) {
        String name = (String) entityManager.createQuery("select name from Student where id=:id").setParameter("id", id).getSingleResult();
        entityManager.close();
        return name;
    }

    @Transactional
    @Override
    public void change(long id, String name) {
        Query query = entityManager.createQuery("update Student s set s.name=:name where s.id=:id");
        query.setParameter("id", id).setParameter("name", name);
        int i = query.executeUpdate();

        System.err.println("=============== " + i);
    }

    @Override
    public boolean save(Student student) {
        return false;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}

package com.moontwon.demo.hibernate.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-2
 */
@Cacheable
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "hibernate-2nd-cache")
public class Student {
    @Id
    private long id;
    private String name;
    private int grade;
    private int age;
    private String address;
    private String email;
    @Where(clause = "")
    private String tel;

    public Student() {
    }

    public Student(long id, String name, int grade, int age, String address, String email, String tel) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

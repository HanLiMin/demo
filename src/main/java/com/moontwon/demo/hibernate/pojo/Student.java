package com.moontwon.demo.hibernate.pojo;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;

import com.moontwon.demo.hibernate.convert.AddressConvert;

@Entity
public class Student {

	@Id
	private long id;
	@Type(type = "string")
	private String name;
	private int grade;
	private int age;
	
	private String email;
	private String address;
	@Convert(converter = AddressConvert.class)
	private String tel;
	public Student() {
	}

	public Student(String name, int grade, int age, String email, String address, String tel) {
		this.name = name;
		this.grade = grade;
		this.age = age;
		this.email = email;
		this.address = address;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}

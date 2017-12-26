package com.moontwon.demo.hibernate.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-9
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "hibernate-2nd-cache")
public class Book {
    @Id
    private  long id;
    @NaturalId
    private String name;
    private LocalDate date;
    @NaturalId
    private String author;
    private int price;
    private int page;
    private int word_count;

    public Book() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }
}

package com.moontwon.demo.spring.service;

import com.moontwon.demo.spring.da.PersionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/13
 */
@Service
public class StudentService {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private Validator validator;

    private BookService bookService;

    public void init() {
        System.err.println("StudentService init method invoken");
        System.err.println(conversionService);
    }

    public void destory() {
        System.err.println("StudentService destory method invoken");
    }

    @Autowired
    public StudentService(BookService bookService) {
        this.bookService = bookService;
    }

    public void add(PersionDO persionDO) {
        Set<ConstraintViolation<PersionDO>> constraintViolationSet = validator.validate(persionDO);
        constraintViolationSet.forEach(e -> System.err.println(e.getMessage()));
    }
}

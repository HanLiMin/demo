package com.moontwon.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.moontwon.spring");
		annotationConfigApplicationContext.getEnvironment().setActiveProfiles("prod");
		annotationConfigApplicationContext.refresh();
		System.err.println(annotationConfigApplicationContext.getBean("string"));
		annotationConfigApplicationContext.getBean(Conllor.class).test();
		annotationConfigApplicationContext.close();
	}
}

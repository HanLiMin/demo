package com.moontwon.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
@Configuration
@EnableAspectJAutoProxy
@EnableSpringConfigured
public class Config {
	@Bean("string")
	@Profile("dev")
	public String a(){
		return "666666666666";
	}
	
	@Bean("string")
	@Profile("prod")
	public String b(){
		return "777777777777";
	}
}

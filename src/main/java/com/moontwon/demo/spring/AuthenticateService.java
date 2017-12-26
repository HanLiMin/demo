package com.moontwon.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class AuthenticateService {
	
	public boolean login(String name,String passwrod){
		if ("666".equals(name)) {
			return true;
		}
		return false;
	}
}

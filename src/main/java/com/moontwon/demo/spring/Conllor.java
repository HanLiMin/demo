package com.moontwon.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Conllor {
	@Autowired
	private AuthenticateService authenticateService;
	public void test(){
		authenticateService.login("6626", "777");
	}
}

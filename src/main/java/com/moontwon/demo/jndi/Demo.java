package com.moontwon.demo.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Demo {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		System.err.println(context.lookup("java:comp/env/string"));
		
	}
}

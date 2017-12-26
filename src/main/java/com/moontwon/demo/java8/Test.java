package com.moontwon.demo.java8;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Test {
	public static void main(String[] args) {
		String pwd = RandomStringUtils.randomAlphabetic(16);
		System.err.println(pwd);
		System.err.println(DigestUtils.sha256Hex(pwd));

	}
}

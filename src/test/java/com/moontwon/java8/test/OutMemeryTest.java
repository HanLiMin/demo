package com.moontwon.java8.test;

import java.util.ArrayList;
import java.util.List;

public class OutMemeryTest {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		while (true) {
			list.add(new Object());
		}
		
	}
}

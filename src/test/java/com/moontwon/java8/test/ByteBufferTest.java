package com.moontwon.java8.test;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.junit.Test;

public class ByteBufferTest {
	@Test
	public void createTest() {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(1);
			buffer.putInt(1);
			buffer.flip();
			byte[] ge = new byte[buffer.remaining()];
			buffer.get(ge);
			System.err.println(Arrays.toString(ge));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

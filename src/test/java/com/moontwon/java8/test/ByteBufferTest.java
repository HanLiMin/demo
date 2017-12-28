package com.moontwon.java8.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import org.junit.Test;

public class ByteBufferTest {
	@Test
	public void createTest() throws InterruptedException {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.putInt(1);
		buffer.flip();
		byte[] ge = new byte[buffer.remaining()];
		buffer.get(ge);
		System.err.println(Arrays.toString(ge));
		buffer.clear();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putInt(1);
		buffer.flip();
		byte[] le = new byte[buffer.remaining()];
		buffer.get(le);
		System.err.println(Arrays.toString(le));
	}
}

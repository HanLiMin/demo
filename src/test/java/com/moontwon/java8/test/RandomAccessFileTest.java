package com.moontwon.java8.test;

import java.io.File;
import java.io.RandomAccessFile;

import org.junit.Test;

public class RandomAccessFileTest {
	@Test
	public void createTest() throws Exception{
		File file = new File("D:/demo.text");
		if (!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
		accessFile.writeByte(255);
		accessFile.close();
	}
}

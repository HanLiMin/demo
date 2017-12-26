package com.moontwon.java8.test;

import java.nio.charset.Charset;
import java.util.Arrays;

import com.google.common.base.Charsets;

public class TempTest {
	public static void main(String[] args) {
//		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{-26, -120, -111,-26,-120});
//		CharsetDecoder decoder = Charsets.UTF_8.newDecoder();
//		try {
//			System.err.println(decoder.de);
//		} catch (CharacterCodingException e) {
//			e.printStackTrace();
//		}
		System.err.println(Arrays.toString("\n".getBytes(Charsets.UTF_8)) );
		System.err.println(Arrays.toString("\n".getBytes(Charsets.US_ASCII)) );
		System.err.println(Arrays.toString("\n".getBytes(Charsets.ISO_8859_1)) );
		System.err.println(Arrays.toString("\n".getBytes(Charsets.UTF_16)));
		System.err.println(Arrays.toString("\n".getBytes(Charset.forName("GBK"))) );
	}
}
package com.moontwon.java8.test;

public class GCTest {
	public static GCTest GC_TEST=new GCTest();
	public void isAlive() {
		System.out.println("GCTest.isAlive()");
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		GC_TEST = this;
	}
	public static void main(String[] args) throws InterruptedException {
		GC_TEST.isAlive();
//		GC_TEST = null;
//		System.gc();
//		Thread.sleep(500);
//		GC_TEST.isAlive();
//		GC_TEST = null;
//		System.gc();
//		Thread.sleep(500);
//		GC_TEST.isAlive();
	}
}

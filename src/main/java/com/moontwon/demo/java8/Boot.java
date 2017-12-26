package com.moontwon.demo.java8;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Boot {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(()->{
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Random random = new Random();
			for(;;){
				System.err.println("#1   ="+random.nextInt());
				Thread.sleep(2000);
			}
		});
		service.submit(()->{
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Random random = new Random();
			for(;;){
				System.err.println("#2   ="+random.nextInt());
				Thread.sleep(2000);
			}
		});
		countDownLatch.countDown();
	}

}

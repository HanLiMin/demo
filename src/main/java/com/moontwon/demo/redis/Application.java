package com.moontwon.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("192.168.1.124", 6379);
		jedis.subscribe(new JedisPubSub() {
			@Override
			public void onMessage(String channel, String message) {
				System.err.println(channel+":"+message);
				System.err.println();
			}
		}, "12");
		int age=213;
		Thread.sleep(1000*10000);
		jedis.close();
	}
}
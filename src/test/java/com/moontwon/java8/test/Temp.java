package com.moontwon.java8.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class Temp {
	public static void main(String[] args) throws IOException {

		ServerSocketChannel channel = ServerSocketChannel.open();
		System.err.println(channel.validOps());
		channel.socket().bind(new InetSocketAddress("0.0.0.0", 6666));
		channel.configureBlocking(false);
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);
		for (;;) {
			if (selector.select() > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while(iterator.hasNext()){
					SelectionKey key = iterator.next();
					System.err.println(key.isAcceptable());
				}
			}
		}

	}
}

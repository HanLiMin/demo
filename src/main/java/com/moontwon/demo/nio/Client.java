package com.moontwon.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client  {

	private final static Logger LOGGER = LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) throws IOException {
	}

	public Client() {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			if (socketChannel.connect(new InetSocketAddress("127.0.0.1", 6666))) {
				socketChannel.register(selector, SelectionKey.OP_WRITE);
			} else {
				socketChannel.register(selector, SelectionKey.OP_CONNECT);
			}
			
			for(;;){
				if (selector.select()>0) {
				}
			}
			
			
		} catch (Exception e) {
			handleException(e);
		}
		
	}


	private void handleException(Exception e) {
		LOGGER.info("client throw a exception", e);
	}

}

package com.moontwon.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server extends Thread {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
	public static void main(String[] args) throws IOException {
		new Server();
	}

	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	private EventLoopHandler eventLoopHandler;

	public Server() throws IOException {
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress("0.0.0.0", 6666));
		serverSocketChannel.configureBlocking(false);
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		eventLoopHandler = new EventLoopHandler();
		start();
		eventLoopHandler.start();
	}

	@Override
	public void run() {
		LOGGER.info("nio server start");
		for (;;) {
			try {
				selector.select();
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				while (keys.hasNext()) {
					handleKey(keys.next());
					keys.remove();
				}
			} catch (Exception e) {
				handlerExecption(e);
			}
		}
	}

	/**
	 * 
	 * @param key
	 *            void
	 * @throws IOException
	 */
	private void handleKey(SelectionKey key) throws IOException {
		if (key.isValid()) {
			if (key.isAcceptable()) {
				ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
				SocketChannel socketChannel = serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				eventLoopHandler.register(socketChannel);
			}
		} else {
			key.cancel();
		}
	}

	/**
	 * 
	 * @param exception
	 *            void
	 */
	private void handlerExecption(Exception exception) {
		exception.printStackTrace();
	}
}

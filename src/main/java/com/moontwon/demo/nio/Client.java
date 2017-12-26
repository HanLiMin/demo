package com.moontwon.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client extends Thread {

	private final static Logger LOGGER = LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) throws IOException {
		new Client().start();
	}

	private SocketChannel channel;
	private Selector selector;
	public Client() throws IOException {
		channel = SocketChannel.open();
		channel.configureBlocking(false);
		selector = Selector.open();
		if (channel.connect(new InetSocketAddress("127.0.0.1", 6666))) {
			channel.register(selector, SelectionKey.OP_WRITE);
		} else {
			channel.register(selector, SelectionKey.OP_CONNECT);
		}
	}

	@Override
	public void run() {
		try {
			for (;;) {
				if (selector.select() > 0) {
					Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
					while (keys.hasNext()) {
						handleKey(keys.next());
						keys.remove();
					}
				}

			}
		} catch (Exception e) {
			handleException(e);
		}

	}
	private void handleKey(SelectionKey key) throws IOException {
		if (key.isValid()) {
			SocketChannel socketChannel = (SocketChannel) key.channel();
			if (key.isConnectable()) {
				socketChannel.finishConnect();
				
			} else if (key.isWritable()) {
				socketChannel.write(ByteBuffer.wrap("666\n777".getBytes()));
			}
			System.err.println("#3");
		} else {
			System.err.println("#0");
		}
	}

	private void handleException(Exception e) {
		LOGGER.info("client throw a exception", e);
	}

}

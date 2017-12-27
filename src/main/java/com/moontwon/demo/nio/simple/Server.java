package com.moontwon.demo.nio.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-26
 */
public class Server extends Thread {

	private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
	public static void main(String[] args) throws IOException {
		new Server().start();
	}

	private ServerSocketChannel serverSocketChannel;
	private Selector selector;

	public Server() throws IOException {
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 6666));
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}

	@Override
	public void run() {
		for (;;) {
			try {
				if (selector.select() > 0) {
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						iterator.remove();
						LOGGER.info("{}",key.hashCode());
						if (key.isValid()) {
							if (key.isAcceptable())
								accept(key);
							else if (key.isReadable())
								read(key);
							else if (key.isWritable())
								write(key);
						}else {
							LOGGER.info("key not valid");
						}
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	private void accept(SelectionKey key) {
		try {
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			handleException("接收客户端连接出现异常", e);
			key.cancel();
		}

	}
	private void read(SelectionKey key) {
		if (key.isValid()) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(512);
			SocketChannel channel = (SocketChannel) key.channel();
			try {
				channel.read(byteBuffer);
				byteBuffer.flip();
				byte[] bytes = new byte[byteBuffer.remaining()];
				byteBuffer.get(bytes);
				String msg = new String(bytes);
				if ("bye".equals(msg)) {
					channel.register(selector, SelectionKey.OP_WRITE);
					LOGGER.info("收到 bye");
				}
				LOGGER.info("服务端收到客户端消息: {}", msg);
			} catch (Exception e) {
				handleException("接收客户端消息读取", e);
				key.cancel();
			}
		}else {
			LOGGER.info("有问题");
			key.cancel();
		}
		

	}

	private void write(SelectionKey key) {
		SocketChannel channel = (SocketChannel) key.channel();
		try {
			channel.write(ByteBuffer.wrap("bye".getBytes()));
			LOGGER.info("服务端已发送消息");
			key.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {
			handleException("发送消息发生异常", e);
			key.cancel();
		}

	}

	private void handleException(String msg, Exception e) {
		LOGGER.info("{}", msg, e);
	}

	class Client {
	}
}

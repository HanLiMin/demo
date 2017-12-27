package com.moontwon.demo.nio.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-26
 */
public class Client {

	private final static Logger LOGGER = LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		Selector selector = Selector.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 6666));
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		while (!stop) {
			if (selector.select() > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();
					if (key.isConnectable()) {
						socketChannel.finishConnect();
						socketChannel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
						LOGGER.info("client side finish connet");
					}
					if (key.isWritable()) {
						LOGGER.info("发送消息：");
						socketChannel.write(ByteBuffer.wrap(scanner.nextLine().getBytes()));
					}
					if (key.isReadable()) {
						scanner.close();
						LOGGER.info("===================================");
						ByteBuffer byteBuffer = ByteBuffer.allocate(512);
						socketChannel.read(byteBuffer);
						byteBuffer.flip();
						byte[] bytes = new byte[byteBuffer.remaining()];
						byteBuffer.get(bytes);
						LOGGER.info("收到消息 {}", new String(bytes));
						socketChannel.close();
						break;
					}
				}
			}
		}
	}
}

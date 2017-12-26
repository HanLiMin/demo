package com.moontwon.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class EventLoopHandler extends Thread {

	private final static Logger LOGGER = LoggerFactory.getLogger(EventLoopHandler.class);
	public final static int BUFF_SIZE = 512;
	private Selector selector;
	private Map<SocketChannel, ChannelMessage> sc = Maps.newConcurrentMap();

	public EventLoopHandler() throws IOException {
		this.selector = Selector.open();
	}

	@Override
	public void run() {
		LOGGER.info("event loop start");
		for (;;) {
			try {
				if (selector.select() > 0) {
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						iterator.remove();
						SocketChannel socketChannel = (SocketChannel) key.channel();
						if (key.isValid()) {
							if (key.isReadable()) {
								LOGGER.info("event loop read");
								ChannelMessage channelMessage = sc.get(socketChannel);
								channelMessage.read();
								key.interestOps(SelectionKey.OP_READ);
							}
							
						}
					}
				}
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	public  boolean register(SocketChannel socketChannel) {
		LOGGER.info("event loop register");
		boolean success = false;
		ChannelMessage channelMessage = new ChannelMessage(socketChannel, ByteBuffer.allocate(BUFF_SIZE));
		sc.put(socketChannel, channelMessage);
		try {
			socketChannel.register(selector, SelectionKey.OP_READ);
			success = true;
		} catch (ClosedChannelException e) {
			success = false;
			sc.remove(socketChannel);
			handleException(e);
		}
		return success;

	}
	public void read(String message) {
		LOGGER.info("server receive message : {}", message);
	}

	public void close() {

	}

	private void handleException(Exception exception) {
		LOGGER.info("throw a exception ",exception);
	}
	class ChannelMessage {
		SocketChannel socketChannel;
		ByteBuffer byteBuffer;
		ChannelMessage(SocketChannel socketChannel, ByteBuffer byteBuffer) {
			this.socketChannel = socketChannel;
			this.byteBuffer = byteBuffer;
		}

		void read() {
			try {
				socketChannel.read(byteBuffer);
				String message = decode();
				if (message != null) {
					EventLoopHandler.this.read(message);
				}
			} catch (Exception e) {
				handleException(e);
			}

		}
		void write() {

		}

		String decode() {
			int eol = findLine();
			if (eol > 0) {
				byte[] v = new byte[eol];
				byteBuffer.get(v);
				byteBuffer.compact();
				return new String(v);
			}
			return null;
		}

		int findLine() {
			if (byteBuffer.hasRemaining()) {
				byte[] bs = new byte[byteBuffer.remaining()];
				byteBuffer.get(bs);
				byteBuffer.rewind();
				for (int i = 0; bs[i++] == '\n' && i < bs.length;) {
					return i;
				}
			}
			return -1;
		}
	}
}

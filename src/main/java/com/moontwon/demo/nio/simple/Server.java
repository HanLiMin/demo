package com.moontwon.demo.nio.simple;

import sun.applet.Main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-26
 */
public class Server extends Thread {
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
        for (; ; ) {
            try {
                if (selector.select() > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            System.err.println("server accept");
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            System.err.println("server side client be readable");
                            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                            Boolean r = (Boolean) key.attachment();
                            SocketChannel channel = (SocketChannel) key.channel();
                            if (r != null && r == Boolean.TRUE) {
                                channel.read(byteBuffer);
                                byteBuffer.flip();
                                byte[] bytes = new byte[byteBuffer.remaining()];
                                byteBuffer.get(bytes);
                                System.err.println(new String(bytes));
                                channel.close();
                                System.err.println("server side client close");
                            }else {
                                channel.read(byteBuffer);
                                byteBuffer.flip();
                                byte[] bytes = new byte[byteBuffer.remaining()];
                                byteBuffer.get(bytes);
                                System.err.println(new String(bytes));
                                channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, true);
                            }

                        } else if (key.isWritable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.write(ByteBuffer.wrap("server said:byte".getBytes()));
                            System.err.println("server side client be writable");
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

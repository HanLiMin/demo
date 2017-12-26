package com.moontwon.demo.nio.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-26
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",6666));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        for(;;){
            if (selector.select()>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()){
                        socketChannel.finishConnect();
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                        System.err.println("client side finish connet");
                    }else if(key.isWritable()){
                        System.err.println("client side writable");
                        socketChannel.write(ByteBuffer.wrap("6666".getBytes()));
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                    }else if(key.isReadable()){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        socketChannel.read(byteBuffer);
                        byteBuffer.flip();
                        byte[] bytes = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bytes);
                        System.err.println(new String(bytes));
                        socketChannel.close();
                        return;
                    }
                }
            }
        }
    }
}

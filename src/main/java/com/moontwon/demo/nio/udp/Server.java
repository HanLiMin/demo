package com.moontwon.demo.nio.udp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-31
 */
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.socket().bind(new InetSocketAddress("localhost", 6666));
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);
        for(;;){
            if (selector.select()>0){
                System.err.println("server read");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (key.isValid()){
                        if (key.isReadable()){
                            datagramChannel.receive(byteBuffer);
                            byteBuffer.flip();
                            byte[] bytes = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bytes);
                            System.err.println(Arrays.toString(bytes));
                            System.err.println(new String(bytes));
                            return;
                        }else {
                            System.err.println("other");
                        }
                    }else {
                        System.err.println("no valid");
                    }
                }

            }
        }

    }
}

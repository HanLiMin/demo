package com.moontwon.demo.nio.udp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * @author hanlimin
 * @email hanlimin.code@foxmail.com
 * @date 17-12-31
 */
public class Client {
    private static  final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress("localhost",6666);
        datagramChannel.send(ByteBuffer.wrap("hello".getBytes()),address);

    }
}

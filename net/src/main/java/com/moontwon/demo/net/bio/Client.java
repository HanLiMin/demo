package com.moontwon.demo.net.bio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 6666);
        socket.connect();
    }


}

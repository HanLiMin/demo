package com.moontwon.demo.net.bio;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MessageHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public MessageHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                String msg = reader.readLine();
                if (msg != null) {
                    writer.write("66666\n");
                    writer.flush();
                    break;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dumpStack();
        interrupt();
    }
}

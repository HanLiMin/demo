package com.moontwon.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server extends Thread{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
	
	private ServerSocket serverSocket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(6666);
	}
	@Override
	public void run() {
		System.err.println(Runtime.getRuntime().availableProcessors());
		for(;;){
			try {
				Socket socket= serverSocket.accept();
				new MessageHandler(socket).start();
			} catch (IOException e) {
				LOGGER.error("server accept throw a exception",e);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
}

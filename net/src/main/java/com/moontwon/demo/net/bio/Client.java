package com.moontwon.demo.net.bio;

import com.google.common.base.Charsets;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 6666);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charsets.UTF_8));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),Charsets.UTF_8));
		writer.write("hi");
		writer.write("hi");
		Thread.sleep(10*1000);
		writer.write("\n");
		writer.flush();
		System.err.println(reader.readLine());
		
	}
}

package com.moontwon.demo.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.common.base.Charsets;

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

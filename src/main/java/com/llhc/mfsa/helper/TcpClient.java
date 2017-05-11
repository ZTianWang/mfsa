package com.llhc.mfsa.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class TcpClient extends Thread{

	private List<String> files;
	
	public TcpClient(List<String> mes) {
		files = mes;
	}
	
	public void run() {
		send();
	}
	
	public void send() {
		try {
			Socket socket = new Socket("127.0.0.1", 8098);
//			InputStream is = new ByteArrayInputStream(mes.getBytes());
//			BufferedReader sin = new BufferedReader(new InputStreamReader(is));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
//			os.println(file);
//			System.out.println("client:"+file);
			for (String file : files) {
				os.println(file);
				System.out.println("client:"+file);
			}
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("server:"+br.readLine());
			br.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

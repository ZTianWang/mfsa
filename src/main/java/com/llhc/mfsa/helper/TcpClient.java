package com.llhc.mfsa.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient extends Thread{

	private String mes;
	
	public TcpClient(String mes) {
		this.mes = mes;
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
//			String line = sin.readLine();
//			while(!line.equals("bye")){
				os.println(mes);
				os.flush();
				System.out.println("client:"+mes);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("server:"+br.readLine());
//				line = sin.readLine();
//			}
				
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

package com.llhc.mfsa.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendHelper extends Thread{

	private Socket socket;
	private String str;

	public SendHelper(Socket socket,String str) {
//		this.socket = socket;
		try {
			this.socket = new Socket("localhost",8098);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.str = str;
	}
	
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();
			pw.close();
			String line = br.readLine();
			if (line != null) {
				socket.close();
				System.out.println("close");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

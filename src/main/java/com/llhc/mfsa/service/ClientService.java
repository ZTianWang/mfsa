package com.llhc.mfsa.service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.helper.SendHelper;

@Service
public class ClientService implements InitializingBean{

	private Socket socket;
	
	public void afterPropertiesSet() throws Exception {
//		try {
//			this.socket = new Socket("localhost",8098);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public void send(String str) {
		SendHelper sendHelper = new SendHelper(socket, str);
		sendHelper.start();
	}
	
}

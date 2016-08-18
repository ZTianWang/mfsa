package com.llhc.mfsa.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SocketService implements InitializingBean{

		public void afterPropertiesSet() throws Exception {
//			init();
		}
		
		private void init() {
			try {
				System.out.println("server start");
				final ServerSocket ss = new ServerSocket(8000);
				System.out.println("server ready");
				
				new Thread(new Runnable() {
					
					public void run() {
						while(true){
							try {
								Socket socket = ss.accept();
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("server connected...");
//				serverThread st = new serverThread(socket);
//				Thread t1 = new Thread(st);
//				t1.start();
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						}
						
					}
				}).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

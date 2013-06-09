package test;

import java.io.*;
import java.net.*;

public class BarneySource {

	public static void main(String[] args) {
		Socket toServer;
		OutputStream stream;
		String destination = "127.0.0.1";
		String send = "Super De Duper";
		byte[] b = new byte[100];
		
		try {
			toServer = new Socket (destination, 9292);
			stream = toServer.getOutputStream();
			b = send.getBytes();
			
			stream.write(b);
			stream.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown Host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Excpetion");
			e.printStackTrace();
		}
		System.out.println("End of Client");

	}

}

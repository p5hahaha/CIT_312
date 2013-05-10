package test;

import java.io.*;
import java.net.*;

public class BarneySource {

	public static void main(String[] args) {
		Socket toServer;
		OutputStream stream;
		byte[] b = new byte[100];
		
		try {
			toServer = new Socket ("127.0.0.1", 9292);
			stream = toServer.getOutputStream();
			String send = "Hey Brett, it works now!";
			b = send.getBytes();
			
			stream.write(b);
			stream.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of Client");

	}

}

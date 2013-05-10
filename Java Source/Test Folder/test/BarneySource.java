package test;

import java.io.*;
import java.net.*;

public class BarneySource {

	public static void main(String[] args) {
		Socket toServer;
		OutputStream stream;
		
		try {
			toServer = new Socket ("127.0.0.1", 9292);
			stream = toServer.getOutputStream();
			String send = "AAA BBB END";
			byte[] b = send.getBytes();
			
			stream.write(b);
			stream.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

package test;

import java.io.*;
import java.net.*;

public class BarneyServerListener {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		ServerSocket ss;
		Socket s;
		
		InputStream stream;
		
		String fromClient = new String();
		byte[] b = new byte[100];
		
		try {
			ss = new ServerSocket(9292);
			s = ss.accept();
			
			stream = s.getInputStream();
			stream.read(b);
			
			fromClient = new String(b);
			
			stream.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(fromClient);
		
	}

}

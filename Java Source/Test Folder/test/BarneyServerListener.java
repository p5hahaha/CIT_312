package test;

import java.io.*;
import java.net.*;

public class BarneyServerListener {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		ServerSocket ss;
		Socket s;
		InputStream in;
		String fromClient = new String();
		byte[] b = null;
		
		try {
			ss = new ServerSocket(9292);
			s = ss.accept();
			while(fromClient == null)
			{
				in = s.getInputStream();
				in.read(b);
				fromClient = b.toString();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fromClient);
		
	}

}

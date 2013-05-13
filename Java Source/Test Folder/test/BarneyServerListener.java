package test;

import java.io.*;
import java.net.*;

public class BarneyServerListener extends Thread{
	public static void main (String[] args)
	{
		ServerSocket ss;
		Socket s;
		int listeningPort = 9292;
		InputStream stream;

		String fromClient = new String();
		byte[] b = new byte[100];


		try {
			ss = new ServerSocket(listeningPort);
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

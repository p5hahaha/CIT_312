package test;

import java.net.*;
import java.io.*;


public class SocketClient {

	public static void main(String[] args){
		String host = "localhost";
		int port = 19999;
		
		StringBuffer instr = new StringBuffer();
		String TimeStamp;
		System.out.println("SocketClient initialized");
		
		try {
			InetAddress address = InetAddress.getByName(host);
			Socket connection = new Socket(address, port);
			
			BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
		}
		catch (Exception e)
		{
			
		}
	}
}

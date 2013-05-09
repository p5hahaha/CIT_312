package test;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.net.Socket;

public class BarneyServerListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int flag = 0;
		BufferedReader in = null;
		String userInput;
		BufferedReader stdIn = new BufferedReader(
				new InputStreamReader(System.in));

		try {
			ServerSocket aListeningSocket = new ServerSocket(9292);
			Socket toClient = aListeningSocket.accept();

			while ((userInput = stdIn.readLine()) != null) 
			{
				in = new BufferedReader(new InputStreamReader(System.in));
			}
			
			aListeningSocket.close();
			toClient.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userInput);
		

	}

}

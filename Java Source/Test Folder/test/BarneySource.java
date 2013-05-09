package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BarneySource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket toServer = new Socket ("127.0.0.1", 9292);
			
			PrintWriter a = new PrintWriter(toServer.getOutputStream(), true);
			a.println("It worked like a charm");
			
			a.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerClientInteraction implements Runnable{
	private Socket fromClientSocket;
	
	private InputStream inStream;
	private String inString;
	
	private byte[] b;
	
	public void setSocket(Socket s){
		this.fromClientSocket = s;
	}
	
	public void run(){

		try {
			inStream = fromClientSocket.getInputStream();
			
			b = new byte[500];
			inStream.read(b);
			inString = new String(b);
			System.out.println(inString);
			fromClientSocket.close(); //Clean-up
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return;
	}
}

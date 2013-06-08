package test.Threading_SocketIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket toServer;
	OutputStream stream;
	byte[] b = new byte[100];
	
	String destinationIP = "127.0.0.1";
	int port;
	String send;
	

	public Client(){
		destinationIP = "127.0.0.1";
		port = 9292;
		send = "Great Day";
	}
	
	public Client(String message){
		this.send = message;
		destinationIP = "127.0.0.1";
		port = 9292;
	}
	
	public void transmit()
	{
		try {
			toServer = new Socket(destinationIP, port);
			stream = toServer.getOutputStream();

			b = send.getBytes();
			stream.write(b);
			stream.flush();
			toServer.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown Host");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("End of Client");
	}
}

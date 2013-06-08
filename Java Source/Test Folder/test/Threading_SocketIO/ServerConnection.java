package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerConnection implements Runnable {

	private Socket fromClient;
	private byte[] b = new byte[100];
	private InputStream stream;
	private String fromClientString;


	public ServerConnection(Socket s) {
		this.fromClient = s;
	}

	@Override
	public void run() {
		try{
			System.out.println("Thread id: " + Thread.currentThread().getName());
			stream = fromClient.getInputStream();
			stream.read(b);
			
		} catch (IOException e) {
			System.out.println("Error in the connection to the client");
			e.printStackTrace();
		}
		fromClientString = new String(b);
		System.out.println(fromClientString);
		Thread.currentThread().stop();
	}
}

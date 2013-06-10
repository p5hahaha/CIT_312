package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListeningServerThree extends Thread{
	//Sockets needed to talk with client
	ServerSocket serverSocket;
	Socket fromClientSocket;
	int port;

	//Strings and streams to message the client
	byte[] b;
	String inString;
	String outString;
	OutputStream outStream;
	InputStream inStream;
	
	Executor organizer = Executors.newCachedThreadPool();
	

	public boolean listen;

	public ListeningServerThree(){
		port = 9292;
		this.listen = true;
	}

	public void stopListening(){
		if (fromClientSocket == null){
			try {
				serverSocket.close();
				listen = false;
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	public void run(){
		try {
			serverSocket = new ServerSocket(port);	//Creates a socket that is ready to listen on the port indicated
			System.out.println("Starting server on thread: " + Thread.currentThread().getName());
			while (listen){
				
				ServerClientInteraction session = new ServerClientInteraction(); //Creates the actual connection between client and server
				session.setSocket(serverSocket.accept());
				organizer.execute(session);
			}
			serverSocket.close();

		} catch(SocketException e){
			System.out.println("Socket Closed");
		} catch (IOException e) {
			System.out.println("Server: IOException");
			e.printStackTrace();
		}
	}
}



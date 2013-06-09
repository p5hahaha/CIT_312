package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ListeningServerTwo extends Thread{
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

	public boolean listen;

	public ListeningServerTwo(){
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
				fromClientSocket = serverSocket.accept(); //Creates the actual connection between client and server
				inStream = fromClientSocket.getInputStream();

				b = new byte[500];

				inStream.read(b);
				inString = new String(b);

				System.out.println(inString);

				fromClientSocket.close(); //Clean-up
			}
			serverSocket.close();

		} catch(SocketException e){
			System.out.println("I closed the Socket Forcibly");
		} catch (IOException e) {
			System.out.println("Server: IOException");
			e.printStackTrace();
		}
		/*try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}
}



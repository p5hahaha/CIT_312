package test.Threading_SocketIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListeningServer5{
	public static void main(String[] args){
		
		//Sockets needed to talk with client
		ServerSocket serverSocket;
		int port = 9292;

		Executor organizer = Executors.newCachedThreadPool();
		Controller controller = new Controller();

		try {
			serverSocket = new ServerSocket(port);	//Creates a socket that is ready to listen on the port indicated
			
			while (true){
				ServerClientInteraction2 session 
					= new ServerClientInteraction2(serverSocket.accept(), controller); 
				
				organizer.execute(session);
				//Thread.currentThread().sleep(100);
			}
		} catch(SocketException e){
			System.out.println("Socket Closed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Server: IOException");
			e.printStackTrace();
			
		} /*catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}



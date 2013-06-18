package test.Threading_SocketIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class testServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			System.out.println("Listening");
			try{
				ServerSocket serverSocket = new ServerSocket(9292);
				Socket fromClient = serverSocket.accept();

				JSONInputStream jsonIn = new JSONInputStream(fromClient.getInputStream());
				JSONOutputStream jsonout = new JSONOutputStream(fromClient.getOutputStream());

				String SfromClient = (String) jsonIn.readObject();

				jsonout.writeObject(SfromClient);
				
				System.out.println(SfromClient);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




	}

}

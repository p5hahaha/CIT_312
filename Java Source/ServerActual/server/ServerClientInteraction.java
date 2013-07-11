package server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import server.MVC.Controller;
import server.CommandBean; 

public class ServerClientInteraction implements Runnable{
	private Socket fromClientSocket;
	private Controller localControl;

	private JSONInputStream jsonIn;
	private JSONOutputStream jsonOut;

	private CommandBean requestFromClient;
	private CommandBean replyToClient;

	private int failureCount;
	private final int FAILURECOUNT = 4;

	ServerClientInteraction(Socket s, Controller c){
		this.fromClientSocket = s;
		this.localControl = c;
	}

	public void run(){

		try {

			boolean loop = true;
			failureCount = 0;

			while(loop && !fromClientSocket.isClosed() && failureCount < FAILURECOUNT) {
				try{
					jsonIn = new JSONInputStream(fromClientSocket.getInputStream());
					jsonOut = new JSONOutputStream(fromClientSocket.getOutputStream());

					HashMap hashRequestFromClient = (HashMap) jsonIn.readObject();
					requestFromClient = localControl.command("createCommandBean",hashRequestFromClient);

					int check = requestFromClient.getCommand().compareToIgnoreCase("bye");
					if (check == 0 )
						loop = false;

					System.out.println(requestFromClient.toString());
					replyToClient = localControl.command(requestFromClient.getCommand(), requestFromClient.getData());

					try {
						jsonOut.writeObject(replyToClient);
					} catch (JSONException e){
						System.out.println("Can't write object");
						e.printStackTrace();
					}

				} catch (JSONException e) {
					failureCount++;
					e.printStackTrace();
				}
			}
			fromClientSocket.close(); //Clean-up
		} catch (IOException e) {
			e.printStackTrace();			
			return;
		}
	}
}

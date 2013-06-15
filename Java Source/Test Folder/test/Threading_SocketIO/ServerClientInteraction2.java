package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class ServerClientInteraction2 implements Runnable{
	private Socket fromClientSocket;
	private Controller localControl;

	private JSONInputStream jsonIn;
	private JSONOutputStream jsonOut;
	
	private CommandBean requestFromClient;
	private CommandBean replyToClient;

	ServerClientInteraction2(Socket s, Controller c){
		this.fromClientSocket = s;
		this.localControl = c;
	}

	public void run(){

		try {
			jsonIn = new JSONInputStream(fromClientSocket.getInputStream());
			jsonOut = new JSONOutputStream(fromClientSocket.getOutputStream());
			
			boolean loop = true;
			
			while(loop){
				requestFromClient = (CommandBean) jsonIn.readObject();
				
				System.out.println(requestFromClient.getCommand());
				
				if (requestFromClient.getCommand() == "bye")
					loop = false;
				jsonOut.writeObject(new CommandBean("Acknowledge","Super de duper"));
			}
			

			fromClientSocket.close(); //Clean-up
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return;
		}
	}
}

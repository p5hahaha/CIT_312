package test.Threading_SocketIO;

import java.io.IOException;

import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;


public class Client {
	Socket toServer;
	OutputStream stream;

	JSONOutputStream jsonOut;
	JSONInputStream jsonIn;

	CommandBean commandToServer;
	HashMap commandFromServer;
	//byte[] b = new byte[100];

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
			jsonOut = new JSONOutputStream(toServer.getOutputStream());
			jsonIn = new JSONInputStream(toServer.getInputStream());
			
			
			try{
				HashMap<String, String> a = new HashMap<String, String>();

				a.clear();
				a.put("username", "jason");
				a.put("password", "super1");

				jsonOut.writeObject(new CommandBean("login", a));
				commandFromServer = (HashMap) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer);
				
				a.clear();
				a.put("username", "jason");
				a.put("password", "super");

				jsonOut.writeObject(new CommandBean("bye", a));
				commandFromServer = (HashMap) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer);


			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toServer.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown Host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception: Server Probably isn't listening");
			e.printStackTrace();
		} 

		System.out.println("End of Client");
	}
}

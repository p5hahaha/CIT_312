package test.Threading_SocketIO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	ObjectOutputStream jsonOut;
	ObjectInputStream jsonIn;

	CommandBean commandToServer;
	CommandBean commandFromServer;
	//byte[] b = new byte[100];

	String destinationIP = "127.0.0.1";
	int port;

	String send;
	HashMap in;

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
			jsonOut = new ObjectOutputStream(toServer.getOutputStream());
			jsonIn = new ObjectInputStream(toServer.getInputStream());

			try{
				HashMap<String, String> a = new HashMap<String, String>();
				a.put("username", "jason");
				a.put("password", "super");
				a.put("firstName", "Jason");
				a.put("lastName", "Ransom");
				
				jsonOut.writeObject(new CommandBean("createUser", a));
				commandFromServer = (CommandBean) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer.command);
				
				a.clear();
				a.put("username", "jason");
				a.put("password", "super1");
				
				jsonOut.writeObject(new CommandBean("login", a));
				commandFromServer = (CommandBean) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer.command + "\nData: "+ commandFromServer.data.toString());
				
				a.clear();
				a.put("username", "jason");
				a.put("password", "super");
				
				jsonOut.writeObject(new CommandBean("login", a));
				commandFromServer = (CommandBean) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer.command + "\nData: "+ commandFromServer.data.toString());
				
				
				jsonOut.writeObject(new CommandBean("bye", a));
				commandFromServer = (CommandBean) jsonIn.readObject();
				System.out.println("Command from server: " + commandFromServer.command);


			} catch (ClassNotFoundException e) {
				System.out.println("I don't understand the class that was sent");
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

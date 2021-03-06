package test.Threading_SocketIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class ServerClientInteraction2 implements Runnable{
	private Socket fromClientSocket;
	private Controller localControl;

	private ObjectInputStream jsonIn;
	private ObjectOutputStream jsonOut;

	private CommandBean requestFromClient;
	private CommandBean replyToClient;

	private int failureCount;

	ServerClientInteraction2(Socket s, Controller c){
		this.fromClientSocket = s;
		this.localControl = c;
	}

	public void run(){

		try {
			System.out.println(Thread.currentThread().getName());
			jsonIn = new ObjectInputStream(fromClientSocket.getInputStream());
			jsonOut = new ObjectOutputStream(fromClientSocket.getOutputStream());

			boolean loop = true;
			failureCount = 0;

			while(loop && !fromClientSocket.isClosed() && failureCount < 3) {
				try{
					requestFromClient = (CommandBean) jsonIn.readObject();

					replyToClient = localControl.command(requestFromClient.command, requestFromClient.data);

					jsonOut.writeObject(replyToClient);
					if (requestFromClient.command == "bye")
						loop = false;

				} catch( IOException e){
					failureCount++;
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
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

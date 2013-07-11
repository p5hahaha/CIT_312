package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;

import test.Threading_SocketIO.CommandBean;


//import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		new HTTP_URL_JSON_Test();
		

		//		ServerSocket serverSocket;
		//		Socket socket;
		//		JSONInputStream jsonIn;
		//		HashMap hashMap;
		//		
		//		try {
		//			serverSocket = new ServerSocket(9292);
		//			socket = serverSocket.accept();
		//			HashMap<String, String> data = new HashMap<String, String>();
		//			
		//			jsonIn = new JSONInputStream(socket.getInputStream());
		//			
		//			hashMap = (HashMap)jsonIn.readObject();
		//			
		//			CommandBean newCommandBean = new CommandBean((String)hashMap.get("command"), (HashMap)hashMap.get("data"));
		//			System.out.println(newCommandBean.getCommand());
		//			
		//			//System.out.println(hashMap.toString());
		//			
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (JSONException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}





		//Date test = new Date(System.currentTimeMillis()); 
		//UUID test2 = UUID.randomUUID();

		//System.out.println(test2.toString());		
	}
	
	static void test (int a){
		System.out.println("It worked");
	}
}

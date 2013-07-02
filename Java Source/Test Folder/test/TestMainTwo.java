package test;

import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import test.HQL_Test.Hibernate;
import test.MVC.User;
import test.Threading_SocketIO.Client;
import test.Threading_SocketIO.CommandBean;
import test.exceptions.InvalidUserException;

public class TestMainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Socket socket;
		try{
			socket = new Socket("127.0.0.1", 9292);
			JSONOutputStream jsonOut = new JSONOutputStream(socket.getOutputStream());
			HashMap<String, String> test = new HashMap<String, String>();
			test.put("username", "jason");
			test.put("password", "super");
			
			CommandBean command = new CommandBean("login", test);
			
			String jsonString = JSONUtilities.stringify(command);
			System.out.println(jsonString);
			jsonOut.writeObject(command);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}


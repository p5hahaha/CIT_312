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
		HashMap a = null;
		if (a == null){
			System.out.println("hit");
		} else {
			System.out.println("miss");
		}
	}

}


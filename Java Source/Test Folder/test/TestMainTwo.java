package test;

import java.util.HashMap;

import test.HQL_Test.Hibernate;
import test.MVC.User;
import test.Threading_SocketIO.Client;
import test.exceptions.InvalidUserException;

public class TestMainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		try {
			String username = "doug";
			String password = "pass";
			
			Hibernate hibernate = new Hibernate();

			//hibernate.createUser(username, password);
			hibernate.loginUser(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


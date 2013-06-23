package test;

import java.util.HashMap;

import test.Ryan.*;

//import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		HashMap<String, Vehicle> vechicleList = new HashMap<String, Vehicle>();
		
		vechicleList.put("Ryan", new Vehicle("Harley", 1988, "Ninja", 4.3, 199, "Ryan"));
		vechicleList.put("please", new Vehicle("Harley", 1988, "Ninja", 4.3, 199, "please"));
		

		
		System.out.println(vechicleList.toString() + '\n');
		
		System.out.println("Number of things in the list = " + Integer.toString(vechicleList.size()));
		
		System.out.println("Number of things in the list = " + Integer.toString(vechicleList.size()));
	}
}

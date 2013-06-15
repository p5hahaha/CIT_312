package test;

import test.MVC.User;
import test.Threading_SocketIO.Client;

public class TestMainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		new Client("TestMain Two Super").transmit();
		//try {Thread.currentThread().sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		new Client("TestMain Karlos Shake").transmit();
		//try {Thread.currentThread().sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		new Client("TestMain over the rainbow Shuffle").transmit();
	}
	
	static void changeName(String u){
		u = "Becky";
	}
}


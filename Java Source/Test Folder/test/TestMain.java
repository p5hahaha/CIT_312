package test;

import test.Threading_SocketIO.*;

//import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		new Client("TestMain Two Super").transmit();
		//new Client("HOwdy").transmit();
	}
}

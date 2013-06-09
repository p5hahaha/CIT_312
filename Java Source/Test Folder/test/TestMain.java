package test;

import test.Threading_SocketIO.*;

import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		//ListeningServer server = new ListeningServer();
		//server.run();
		new Client("HOwdy").transmit();
		//try {Thread.currentThread().sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		new Client("Milk Shake").transmit();
		//try {Thread.currentThread().sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		new Client("Truffle Shuffle").transmit();
	}
}

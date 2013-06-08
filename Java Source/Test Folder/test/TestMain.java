package test;

import test.Threading_SocketIO.*;

import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		ListeningServer server = new ListeningServer();
		server.run();
		new Client("HOwdy");
		new Client("Milk Shake");
		new Client("Truffle Shuffle");
	}
}

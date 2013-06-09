package test;

import test.Threading_SocketIO.ListeningServerTwo;

public class TestMainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ListeningServerTwo server = new ListeningServerTwo();
		server.start();
		
		try {Thread.currentThread().sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		server.stopListening();
		long stop = System.currentTimeMillis();
		
		System.out.println("The server ran for " + Long.toString(stop - start) + " seconds");
		
		
	}

}

package test;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import test.Threading_SocketIO.Client;

public class Test_Multi_Thread {
	public static void main(String[] args){
		new Client().transmit();
	}

}

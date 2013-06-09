package test.Threading_SocketIO;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ListeningServer extends Thread{

	private ServerSocket ss;
	private Socket s;
	private int listeningPort;

	public boolean listen = true; 				//Used to tell whether to run the server 

	Executor executor = Executors.newCachedThreadPool();

	public ListeningServer(){
		this.listeningPort = 9292;
	}

	private void startServer(){
		while(listen){
			try {
				ss = new ServerSocket(listeningPort);
				//s = ss.accept();
				executor.execute(new ServerConnection(ss.accept()));


			} catch (BindException e) {
				this.listen = false;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				this.listen = false;
			}
		}
	}

	public void stopServer(){
		this.listen = false;
	}

	public void run(){
		this.listen = true;
		this.startServer();
	}
}

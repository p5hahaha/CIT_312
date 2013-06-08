package test.Threading_SocketIO;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ListeningServer extends Thread{

	private ServerSocket ss;
	private Socket s;
	private int listeningPort;

	public boolean listen = true; 				//Used to tell whether to run the server 
	
	private final ExecutorService executor = new ThreadPoolExecutor(10,20,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


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

	@SuppressWarnings("deprecation")
	public void stopServer(){
		this.listen = false;
		try{
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Something happened with stopping the threads");
			e.printStackTrace();
		}
		
		this.stop();
	}

	public void run(){
		this.listen = true;
		this.startServer();
	}
}

package test.Threading_SocketIO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executoring {
	public Executoring(){
		try{
			final ExecutorService executor = new ThreadPoolExecutor(2,4,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

			//executor.execute(new ServerConnection());
			//executor.execute(new ServerConnection());
			executor.awaitTermination(10, TimeUnit.SECONDS);
			
		} catch (Exception e)
		{}

		//ListeningServer server = new ListeningServer();	
		//server.startServer();
	}
}

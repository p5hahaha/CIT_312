package test.Threading_SocketIO;

public class ThreadTest extends Thread{

	@SuppressWarnings("static-access")
	public void run(){
		System.out.println("Thread id: "+ Thread.currentThread().getId()
				+" Thread name: "+Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(100);
		}
		catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("End of Thread" + Thread.currentThread().getId());
	}
}
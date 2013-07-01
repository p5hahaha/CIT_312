package test;


import java.util.Date;
import java.util.UUID;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import test.Threading_SocketIO.ListeningServer;


public class TestMain {

	public static void main(String[] args) {
		
		Date test = new Date(System.currentTimeMillis()); 
		UUID test2 = UUID.randomUUID();
		
		System.out.println(test2.toString());		
	}
}

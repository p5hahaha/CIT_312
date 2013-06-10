package test;

import java.io.IOException;
import java.util.Scanner;

import test.Threading_SocketIO.*;

public class TestMainTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String in = "";
		boolean cont = true;
		Scanner input;

		ListeningServerThree server = new ListeningServerThree();
		server.start();

		while (cont){
			in = "";
			System.out.println("Would you like to shutdown the server? (yes/no)");
			input = new Scanner(System.in);
			in = input.nextLine().toLowerCase();

			if (in.contentEquals("yes")){
				server.stopListening();
				cont = false;
			}

		}
	}

}

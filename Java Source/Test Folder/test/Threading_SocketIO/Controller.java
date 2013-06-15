package test.Threading_SocketIO;

import java.util.HashMap;
import javax.xml.ws.handler.Handler;

import test.MVC.GenericCommand;
import test.MVC.GetUser;

public class Controller {
	
	private HashMap<String, GenericCommand> commandMap;
	GenericCommand commandHandler;
	
	public Controller(){
		commandMap = new HashMap<String, GenericCommand>();
		commandMap.put("getUser", new GetUser());
		
		System.out.println("Controller is running");
	}
	
	public CommandBean command(String s){
		commandHandler = commandMap.get(s);
		return new CommandBean("bye",null);
		
	}
}

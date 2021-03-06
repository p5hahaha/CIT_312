package test.Threading_SocketIO;

import java.util.HashMap;
import javax.xml.ws.handler.Handler;

import test.HQL_Test.Hibernate;
import test.MVC.*;

public class Controller {
	
	private HashMap<String, GenericCommand> commandMap;
	private Hibernate hibernate;
	private GenericCommand commandHandler;
	
	public Controller(){
		hibernate = new Hibernate();
		commandMap = new HashMap<String, GenericCommand>();
		
		commandMap.put("createUser", new test.MVC.CreateUser(hibernate));
		commandMap.put("getUser", new test.MVC.GetUser(hibernate));
		commandMap.put("login", new test.MVC.ClientLogin(hibernate));
		commandMap.put("error", new test.MVC.Error());
		
		System.out.println("Controller is running");
	}
	
	public CommandBean command(String command, HashMap<String, String> a){
		if(commandMap.containsKey(command)) {
		commandHandler = commandMap.get(command);
		} else {
			commandHandler = commandMap.get("error");
		}
		
		return commandHandler.action(a); 
		
	}
}

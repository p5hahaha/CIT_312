package server.MVC;

import server.hibernate.Hibernate;
import server.CommandBean;

import java.util.HashMap;
import javax.xml.ws.handler.Handler;

import server.MVC.controllerCommands.*;

public class Controller {
	
	private HashMap<String, GenericCommand> commandMap;
	private Hibernate hibernate;
	private GenericCommand commandHandler;
	
	public Controller(){
		hibernate = new Hibernate();
		commandMap = new HashMap<String, GenericCommand>();
		
		commandMap.put("login", new server.MVC.controllerCommands.ClientLogin(hibernate));
		commandMap.put("createUser", new server.MVC.controllerCommands.CreateUser(hibernate));
		commandMap.put("getUser", new server.MVC.controllerCommands.GetUser(hibernate));
		
		commandMap.put("error", new server.MVC.controllerCommands.Error());
		
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

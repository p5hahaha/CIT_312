package server.MVC.controllerCommands;

import server.hibernate.Hibernate;
import server.CommandBean;

import java.util.HashMap;
import javax.xml.ws.handler.MessageContext;



public class GetUser extends GenericCommand{
	
	public GetUser(Hibernate hibernate) {
		super(hibernate);
	}

	@Override
	public CommandBean action(HashMap<String, String> a){
		return new CommandBean("Action: GetUser", new HashMap<String,String>());
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(MessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleMessage(MessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

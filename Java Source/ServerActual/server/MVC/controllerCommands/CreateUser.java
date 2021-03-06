package server.MVC.controllerCommands;

import server.CommandBean;
import server.hibernate.Hibernate;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import server.exception.InvalidUserException;


public class CreateUser extends GenericCommand{


	public CreateUser(Hibernate hibernate) {
		super(hibernate);

	}

	@Override
	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handleFault(MessageContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleMessage(MessageContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommandBean action(HashMap<String, String> a) {
		CommandBean replyBean = new CommandBean();
		try {
			
			if (a.containsKey("username") && a.containsKey("password")){
				this.hibernate.createUser(a.get("username"), a.get("password"), a.get("firstName"), a.get("lastName"));
				replyBean.addValue("status", "success");
				replyBean.addValue("username", a.get("username"));
			} else {
				throw new InvalidUserException("Creating User: Must contain a unique username and password");
			}
		} catch (InvalidUserException e){
			replyBean.addValue("error", e.getMessage());
			replyBean.setCommand("error");
		}
		return replyBean;
	}


}

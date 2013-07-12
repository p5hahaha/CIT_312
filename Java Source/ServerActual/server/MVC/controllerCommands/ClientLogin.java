package server.MVC.controllerCommands;

import server.CommandBean;
import server.hibernate.Hibernate;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import server.exception.InvalidUserException;


public class ClientLogin extends GenericCommand{

	public ClientLogin(Hibernate hibernate) {
		super(hibernate);
		// TODO Auto-generated constructor stub
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
		int userId;
		
		try {
			if(a.containsKey("username") && a.containsKey("password")){
				String session = "";
				if(a.containsKey("androidId")){
					String androidId = a.get("androidId");
					userId = this.hibernate.loginUser(a.get("username"), a.get("password"));
					session = this.hibernate.createUserSession(userId,androidId);

					replyBean.setCommand("loginUser");
					replyBean.addValue("status", "success");
					replyBean.addValue("sessionId", session);
				} else {
					throw new InvalidUserException("Android Device must supply Android Id");
				}
			} else {
				throw new InvalidUserException("Must contain a username and password");
			}

		} catch (InvalidUserException e){
			replyBean.setCommand("error");
			replyBean.addValue("status", "error");
			replyBean.addValue("message", e.getMessage());
		}

		return replyBean;
	}

}

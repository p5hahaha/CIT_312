package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;
import test.exceptions.InvalidUserException;

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
		String session;
		
		try {
			if(a.containsKey("username") && a.containsKey("password")){
				session = this.hibernate.loginUser(a.get("username"), a.get("password"));
				replyBean.setCommand("loginUser");
				replyBean.addValue("status", "success");
				replyBean.addValue("session", "1234");
			} else {
				throw new InvalidUserException("Must contain a username and password");
			}
			
		} catch (InvalidUserException e){
			
		}
		
		return new CommandBean("login", new HashMap<String, String>());
	}

}

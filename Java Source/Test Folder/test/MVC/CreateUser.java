package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;

public class CreateUser extends GenericCommand{

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
	public CommandBean action(HashMap<String, String> a, Hibernate hibernate) {
		CommandBean replyBean = new CommandBean();
		
		if (a.containsKey("username") && a.containsKey("password")){
			hibernate.createUser(a.get("username"), a.get("password"), a.get("firstName"), a.get("lastName"));
		} else {
			
		}
		
		
		return replyBean;
	}
	

}

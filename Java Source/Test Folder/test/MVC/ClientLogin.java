package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;

public class ClientLogin extends GenericCommand{
	
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
		
		return new CommandBean("login", new HashMap<String, String>());
	}

}

package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;

public class Error extends GenericCommand{

	@Override
	public CommandBean action(HashMap<String, String> a, Hibernate hibernate){
		HashMap<String, String> e = new HashMap<String, String>();
		e.put("errorCode", "Incorrect Command");
		return new CommandBean("error", e);
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
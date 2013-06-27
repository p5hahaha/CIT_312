package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;

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

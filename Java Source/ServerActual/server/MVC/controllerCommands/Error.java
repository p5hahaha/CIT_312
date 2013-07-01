package server.MVC.controllerCommands;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import server.CommandBean;


public class Error extends GenericCommand{

	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandBean action(HashMap<String, String> a){
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
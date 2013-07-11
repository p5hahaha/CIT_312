package server.MVC.controllerCommands;

import java.util.HashMap;

import javax.xml.ws.handler.MessageContext;

import server.CommandBean;

public class CreateCommandBean extends GenericCommand{

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
	public CommandBean action(HashMap a) {
		CommandBean replyBean = new CommandBean();
		
		replyBean.setCommand((String)a.get("command"));
		replyBean.setData((HashMap)a.get("data"));
		
		return replyBean;
	}

}

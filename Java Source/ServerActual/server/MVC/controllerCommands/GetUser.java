package server.MVC.controllerCommands;

import server.hibernate.Hibernate;
import server.hibernate.tableClasses.User;
import server.CommandBean;

import java.util.HashMap;
import javax.xml.ws.handler.MessageContext;



public class GetUser extends GenericCommand{

	public GetUser(Hibernate hibernate) {
		super(hibernate);
	}

	@Override
	public CommandBean action(HashMap<String, String> a){
		User user;
		CommandBean replyBean = new CommandBean();

		if (a.containsKey("sessionId")){
			String sessionId = a.get("sessionId");
			try{
				user = hibernate.getUser(sessionId);
				replyBean.setCommand("getUser");
				replyBean.addValue("username", user.getUname());
				replyBean.addValue("firstName", user.getFirst_name());
				replyBean.addValue("lastName", user.getLast_name());
			} catch (Exception e){
				e.printStackTrace();
				replyBean.setCommand("error");
				replyBean.addValue("status", "error");
				replyBean.addValue("message", "Invalid session id");
			}
		} else {
			replyBean.setCommand("error");
			replyBean.addValue("status", "error");
			replyBean.addValue("message", "Must contain a session id");
		}


		return replyBean;
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

package test.MVC;

import javax.xml.ws.handler.MessageContext;

public class GetUser extends GenericCommand{
	
	@Override
	public boolean action(String s){
		boolean success = false;
		
		success = true;
		return success;
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

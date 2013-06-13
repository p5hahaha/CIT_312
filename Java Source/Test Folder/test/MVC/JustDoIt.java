package test.MVC;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

public class JustDoIt implements Handler{

	public void handleit(){
		
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

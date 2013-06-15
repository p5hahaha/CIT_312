package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;

import test.Threading_SocketIO.CommandBean;

public abstract class GenericCommand implements Handler{
	public abstract CommandBean action(HashMap<String, String> a);

}

package test.MVC;

import javax.xml.ws.handler.Handler;

public abstract class GenericCommand implements Handler{
	abstract boolean action(String s);

}

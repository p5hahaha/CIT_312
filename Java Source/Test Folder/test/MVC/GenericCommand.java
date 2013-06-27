package test.MVC;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;

import test.HQL_Test.Hibernate;
import test.Threading_SocketIO.CommandBean;

public abstract class GenericCommand implements Handler{
	protected Hibernate hibernate;
	
	public GenericCommand(){
		
	}
	
	public GenericCommand(Hibernate hibernate){
		this.hibernate = hibernate;
	}
	
	public void setHibernate(Hibernate hibernate){
		this.hibernate = hibernate;
	}
	public abstract CommandBean action(HashMap<String, String> a);
	

}

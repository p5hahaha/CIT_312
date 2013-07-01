package server.MVC.controllerCommands;

import server.CommandBean;
import server.hibernate.Hibernate;

import java.util.HashMap;

import javax.xml.ws.handler.Handler;


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

package test.Threading_SocketIO;

import java.io.Serializable;
import java.util.HashMap;

public class CommandBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String command;
	HashMap<String, String> data;

	public CommandBean(){
		
	}
	
	public CommandBean(String c, String key, String d){
		this.command = c;
		data = new HashMap<String, String>();
		this.data.put(key, d);
	}
	
	public CommandBean(String c, HashMap<String, String> h){
		this.command = c;
		data = h;
	}
	
	public void addValue(String key, String value){
	
		this.data.put(key, value);
	}

}

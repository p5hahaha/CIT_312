package test.Threading_SocketIO;

import java.io.Serializable;

public class CommandBean implements Serializable{
	
	private String command;
	private String data;
	
	CommandBean(String c, String d){
		this.command = c;
		this.data = d;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}

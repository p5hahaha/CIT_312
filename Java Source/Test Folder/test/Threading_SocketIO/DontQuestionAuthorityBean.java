package test.Threading_SocketIO;

public class DontQuestionAuthorityBean {
	String command;
	String data;
	String session;
	
	DontQuestionAuthorityBean(String command, String data){
		this.command = command;
		this.data = data;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
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

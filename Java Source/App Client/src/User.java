import java.util.Arrays;

/**
 * 
 */
/**
 * @author 11T7
 *
 */
public class User {

	String userName;
	String passWord;
	
	public User(String userName, String passWord){
	this.userName = userName;
	this.passWord = passWord;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setVehicles(Vehicle[] vehicles) {
		this.vehicles = vehicles;
	}

	Vehicle[] vehicles = new Vehicle[0];
	int defaultVehicle;
	
	public User(){
	}
	
	public Vehicle[] getVehicles() {
		return vehicles;
	}
	public void setVehicles(Vehicle toAdd) {
		this.vehicles = addElement(this.vehicles, toAdd);
	}
	public int getDefaultVehicle() {
		return defaultVehicle;
	}
	public void setDefaultVehicle(int defaultVehicle) {
		this.defaultVehicle = defaultVehicle;
	}
	
	public Vehicle[] addElement(Vehicle[] org, Vehicle added) {
	    Vehicle[] result = Arrays.copyOf(org, org.length +1);
	    result[org.length] = added;
	    return result;
	}

	public String defaultToString(){
		String info = "Default Vehicle:\n\n";
				
		info += this.vehicles[this.defaultVehicle].toString();
		info += "\nVehicle Number: " + this.defaultVehicle;
		
		return info;
	}
	
	public String toString() {
		String info = "All Vehicles: \n\n";
		
		for (int i = 0; i < this.vehicles.length; i++){
			info += this.vehicles[i].toString();
			info += "\nVehicle Number: " + i;
			info += "\n\n";
		}

		return info;
		
	}
	
}
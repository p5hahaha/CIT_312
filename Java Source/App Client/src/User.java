import java.util.HashMap;

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
	HashMap<Integer, Vehicle> vehicleList = new HashMap<Integer, Vehicle>();
	int defaultVehicle;
	
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
	
	public HashMap<Integer, Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(HashMap<Integer, Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public User(){
	}
	
	public void setVehicles(Vehicle toAdd) {
		this.vehicleList = addElement(this.vehicleList, toAdd);
	}
	public void removeVehicle(int toTakeOut){
		this.vehicleList.remove(toTakeOut);
	}
	public int getDefaultVehicle() {
		return defaultVehicle;
	}
	public void setDefaultVehicle(int defaultVehicle) {
		this.defaultVehicle = defaultVehicle;
	}
	
	public HashMap<Integer, Vehicle> addElement(HashMap<Integer, Vehicle> vehicleList, Vehicle added) {
		
		vehicleList.put(vehicleList.size(), added);
//	    Vehicle[] result = Arrays.copyOf(org, org.length +1);
//	    result[org.length] = added;
//	    return result;
		return vehicleList;
	}

	public String defaultToString(){
		String info = "Default Vehicle:\n\n";
		
		info += vehicleList.get(this.defaultVehicle).toString();
		
//		info += this.vehicles[this.defaultVehicle].toString();
		info += "\nVehicle Number: " + this.defaultVehicle;
		
		return info;
	}
	
	public String toString() {
		String info = "All Vehicles: \n\n";
		
		for (int i = 0; i < this.vehicleList.size(); i++){
			if (i == this.defaultVehicle){
				info += "\nDefault Vehicle\n";
			}
			info += this.vehicleList.get(i).toString();
			info += "\nVehicle Number: " + i;
			info += "\n\n";
		}

		return info;
		
	}
	
}
package test.Ryan;

/**
 * 
 */
/**
 * @author 11T7
 *
 */
public class Vehicle {

	String vehicleManufacture;
	int vehicleYear;
	String vehicle;
	double vehicleAverageMPG;
	double vehicleGasTankSize;
	double vehicleCurrentGasAmount;
	double vehicleOdometer;
	String vehicleName;

	public Vehicle(){
	}
	
	public Vehicle(String man, int year, String bike, double tankSize, int odom, String name){
		this.vehicleManufacture = man;
		this.vehicleYear = year;
		this.vehicle = bike;
		this.vehicleGasTankSize = tankSize;
		this.vehicleOdometer = odom;
		this.vehicleName = name;
	}
	
	public Vehicle(double aveMPG, double tankSize, int odom, String name){
		this.vehicle = "Custom";
		this.vehicleAverageMPG = aveMPG;
		this.vehicleGasTankSize = tankSize;
		this.vehicleOdometer = odom;
		this.vehicleName = name;
	}
	
	public String getVehicleManufacture() {
		return vehicleManufacture;
	}
	public void setVehicleManufacture(String vehicleManufacture) {
		this.vehicleManufacture = vehicleManufacture;
	}
	
	public int getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	public double getVehicleAverageMPG() {
		return vehicleAverageMPG;
	}
	public void setVehicleAverageMPG(double vehicleAverageMPG) {
		this.vehicleAverageMPG = vehicleAverageMPG;
	}
	
	public double getVehicleGasTankSize() {
		return vehicleGasTankSize;
	}
	public void setVehicleGasTankSize(double vehicleGasTankSize) {
		this.vehicleGasTankSize = vehicleGasTankSize;
	}
	
	public double getVehicleCurrentGasAmount() {
		return vehicleCurrentGasAmount;
	}
	public void setVehicleCurrentGasAmount(double vehicleCurrentGasAmount) {
		this.vehicleCurrentGasAmount = vehicleCurrentGasAmount;
	}
	
	public double getVehicleOdometer() {
		return vehicleOdometer;
	}
	public void setVehicleOdometer(double vehicleOdometer) {
		this.vehicleOdometer = vehicleOdometer;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}	

	public String toString() {
		String info;
		
		info = "Vehicle: " + this.vehicleName
			 + "\nManufacture: " + this.vehicleManufacture
			 + "\nYear: " + this.vehicleYear
			 + "\nVehicle: " + this.vehicle
			 + "\nAverage MPG: " + this.vehicleAverageMPG
			 + "\nTank Capacity: " + this.vehicleGasTankSize
			 + "\nCurrent Amount of Gas: " + this.vehicleCurrentGasAmount
			 + "\nCurrent Odometer: " + this.vehicleOdometer;
		
		return info;
	}
	
}
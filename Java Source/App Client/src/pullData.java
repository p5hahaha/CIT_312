import java.util.Scanner;

/**
 * 
 */
/**
 * @author 11T7
 *
 */
public class pullData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		
		User defaultUser = null;
		
		defaultUser = new User("Daniel", "Ryan");
		
		Vehicle newV = new Vehicle(42, 4.7, 1234, "ManofSteel");
		defaultUser.setVehicles(newV);
		
		char menu = 's';
		String in = "x";
		
		while (menu != 'q')
		{
			System.out.println("\n\nMenu\n\nCreate User: \tn" +
								"\nAdd Bike: \ta" +
								"\nRemove Bike: \tr" +
								"\nChange Bike: \tc" +
								"\nDisplay Bike: \td" +
								"\nGet Gas: \tf" +
								"\nFill Tank \tF" +
								"\nUse Gas: \tg" +
								"\nMiles Driven: \tm" +
								"\nOdometer: \to" +
								"\nQuit: \t\tq\n");
			
			in = input.nextLine();

			if (!in.isEmpty()){
				menu = in.charAt(0);
			}
			else {
				menu = 'x';
			}
			
			switch (menu) {
			
			case 'n': 
				System.out.println("New User");
				defaultUser = registerUser();
				break;
			case 'a':
				System.out.println("Add Vehicle");
				addVehicle(defaultUser);
				break;
			case 'r':
				System.out.println("Add Vehicle");
				removeBike(defaultUser);
				break;
			case 'c':
				System.out.println("Change Default Vehicle");
				changeVehicle(defaultUser);
				break;
			case 'd':
				System.out.println("Display Vehcicles");
				System.out.println("User "+ defaultUser.getUserName() + ":\n");
				System.out.println(defaultUser.toString());
				break;
			case 'f':
				System.out.println("Get Gas");
				fillTank(defaultUser);
				System.out.println(defaultUser.defaultToString());
				break;
			case 'F':
				System.out.println("Fill Tank");
				fillTankFull(defaultUser);
				System.out.println(defaultUser.defaultToString());
				break;
			case 'g':
				System.out.println("How Much Gas Used?");
				useGas(defaultUser, input.nextDouble());
				System.out.println(defaultUser.defaultToString());
				break;
			case 'm':
				System.out.println("Miles Driven?");
				double inD = input.nextDouble();
				milesDriven(defaultUser, inD);
				System.out.println(defaultUser.defaultToString());
				break;
			case 'o':
				System.out.println("Starting Odometer:");
				int inS = input.nextInt();
				System.out.println("Ending Odometer:");
				int inE = input.nextInt();
				int odom = inE - inS;
				if (odom > 0){
					milesDriven(defaultUser, odom);
					break;
				}
				else {
					System.out.println("Cannot drive negative miles");
					break;
				}
			case 'q':
				System.out.println("Quit");
				break;
			default:
				break;
			}
			
			in = null;
			menu = 's';
			
		}

		System.out.print("Thank You");
	}

	public static User registerUser() {
		
		Scanner input = new Scanner(System.in);
		
		String userName =  null;
		String passWord = null;
		
		char usernamePasswordUnique = 'n';
		
		while (usernamePasswordUnique != 'y'){
		
			String confirmPassWord = null;
			
			System.out.println("Enter new username: ");
			userName = input.nextLine();
			
			System.out.println("Thanks " + userName);
			
			System.out.println("Enter new password: ");
			passWord = input.nextLine();
			
			while (passWord.equals(confirmPassWord) != true){
				System.out.println("Please Confirm password: ");
				confirmPassWord = input.nextLine();	
			}
			
			System.out.println("Combo Unqiue? ");
			usernamePasswordUnique = input.nextLine().charAt(0);
			
		}
		
		User newUser = new User(userName, passWord);
		
		return newUser;
		
	}
	
	public static void addVehicle(User currentUser) {

		Scanner input = new Scanner(System.in);
		
		Vehicle newV = null;
		
		System.out.println("Generic(g) or Custom(c) Bike:");
		char typeOfBike = input.nextLine().charAt(0);
		
		double mpg;
		double tankSize;
		int odometer;
		String vehicleName;
		String man;
		int year;
		String bike;
		
		switch (typeOfBike){
		
		case 'c':
			System.out.println("Enter Average MPG: ");
			mpg = Double.parseDouble(input.nextLine());
			System.out.println("Enter Gas Tank Size: ");
			tankSize = Double.parseDouble(input.nextLine());
			System.out.println("Enter Current Odometer: ");
			odometer = Integer.parseInt(input.nextLine());
			System.out.println("Enter Vehicle Name: ");
			vehicleName = input.nextLine();
			

			newV = new Vehicle(mpg, tankSize, odometer, vehicleName);
			
			break;
			
		case 'g':
			System.out.println("Select Manufacture: ");
			man = input.nextLine();
			System.out.println("Enter Bike Year: ");
			year = Integer.parseInt(input.nextLine());
			System.out.println("Select Bike: ");
			bike = input.nextLine();
			System.out.println("Enter Gas Tank Size: ");
			tankSize = Double.parseDouble(input.nextLine());
			System.out.println("Enter Current Odometer: ");
			odometer = Integer.parseInt(input.nextLine());
			System.out.println("Enter Vehicle Name: ");
			vehicleName = input.nextLine();
			
			newV = new Vehicle(man, year, bike, tankSize, odometer, vehicleName);
			
			break;
		
		}
		
		currentUser.setVehicles(newV);
		
	}
	
	public static void removeBike(User defaultUser) {
		Scanner input = new Scanner(System.in);
		String info = "";
		
		for (int i = 0; i < defaultUser.vehicleList.size(); i++){
			info += defaultUser.vehicleList.get(i).getVehicleName();
			info += "\nVehicle Number: " + i;
			info += "\n\n";
		}
		
		System.out.println(info + "\n\nWhich vehicle to remove?");
	
		int def = input.nextInt();
		
		defaultUser.removeVehicle(def);
		
		info = "";
		
		for (int i = 0; i < defaultUser.vehicleList.size(); i++){
			info += defaultUser.vehicleList.get(i).getVehicleName();
			info += "\nVehicle Number: " + i;
			info += "\n\n";
		}
		
		System.out.println(info);
		
	}
	
	public static void changeVehicle(User defaultUser){
		Scanner input = new Scanner(System.in);
		
		String info = "All Vehicles: \n\n";
		
		for (int i = 0; i < defaultUser.vehicleList.size(); i++){
			info += defaultUser.vehicleList.get(i).getVehicleName();
			info += "\nVehicle Number: " + i;
			info += "\n\n";
		}
		
		System.out.println(info + "\n\nWhich Vehicle do you want to be default?");
		
		int def = input.nextInt();
		
		defaultUser.setDefaultVehicle(def);
		
	}
	
	public static void fillTank(User defaultUser){
		
		Scanner input = new Scanner(System.in);
		double gas;
		
		int defaultVehicle = defaultUser.getDefaultVehicle();
		
//		defaultUser.vehicles[defaultVehicle].getVehicleGasTankSize();
		
		System.out.println("How much gas to add?");

		gas = input.nextDouble();
		
		if (defaultUser.vehicleList.get(defaultVehicle).getVehicleCurrentGasAmount() + gas <= defaultUser.vehicleList.get(defaultVehicle).getVehicleGasTankSize()) {
			defaultUser.vehicleList.get(defaultVehicle).setVehicleCurrentGasAmount(gas + defaultUser.vehicleList.get(defaultVehicle).getVehicleCurrentGasAmount());
		}
		else {
			System.out.println("Don't Overfill Tank\n");
		}
	}
	
	public static void fillTankFull(User defaultUser){

		defaultUser.vehicleList.get(defaultUser.getDefaultVehicle()).setVehicleCurrentGasAmount(defaultUser.vehicleList.get(defaultUser.getDefaultVehicle()).getVehicleGasTankSize());

	}
	
	public static boolean useGas(User defaultUser, double gasUsed){
		
		double gas;
		
		int defaultVehicle = defaultUser.getDefaultVehicle();
		
		gas = defaultUser.vehicleList.get(defaultVehicle).getVehicleCurrentGasAmount();
		
		if (gas - gasUsed >= 0){
			gas -= gasUsed;
			defaultUser.vehicleList.get(defaultVehicle).setVehicleCurrentGasAmount(gas);
			return true;
		}
		
		return false;
		
	}
	
	public static void milesDriven(User defaultUser, double milesDriven){
		
		int defaultVehicle = defaultUser.getDefaultVehicle();
		double mpg = defaultUser.vehicleList.get(defaultVehicle).getVehicleAverageMPG();
//		double gas = defaultUser.vehicleList.get(defaultVehicle).getVehicleCurrentGasAmount();
		
		double gasUsed = milesDriven / mpg;
		
		if (useGas(defaultUser, gasUsed)){

		defaultUser.vehicleList.get(defaultVehicle).setVehicleOdometer(milesDriven + defaultUser.vehicleList.get(defaultVehicle).getVehicleOdometer());
		
		}
		
		else {
			System.out.println("Can't drive that far on that amount of gas");
		}
		
	}
	
}
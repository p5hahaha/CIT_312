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

		User defaultUser = registerUser();
		
		addVehicle(defaultUser);
		
		System.out.println("User "+ defaultUser.getUserName() + ":\n");
		System.out.println(defaultUser.toString());
		
		
/*		Vehicle vOne = new Vehicle("Harley-Davidson", 2013, "SuperLow",4.5, 0, "supeLow");
	
		vOne.setVehicleAverageMPG(43);
	
		Vehicle vTwo = new Vehicle(43.0, 5, 0, "SuperGlide Custom");

		vOne.setVehicleCurrentGasAmount(4);
		vTwo.setVehicleCurrentGasAmount(4.9);
		
		User uOne = new User();
		
		uOne.setVehicles(vOne);
		uOne.setVehicles(vTwo);
		
		uOne.setDefaultVehicle(0);
		
		System.out.println("User One:\n");
		System.out.println(uOne.toString());
		
		System.out.println(uOne.defaultToString());
*/		System.out.print("Thank You");
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
	
}
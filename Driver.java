package salesVignettes;

import salesVignettes.GasStation;
import salesVignettes.Vehicle;

public class Driver {
	
	private String name;
	private Vehicle[] myVehicles;
	private float money;
	private GasStation myGasStation;
	private int numberOfVehicles;
	private int indexAddVehicles;
	
	Driver(String name, float money, GasStation myGasStation, int numberOfVehicles) {
		this.name = (name != null && name.length() > 0) ? name : "No name";
		this.money = (money > 0) ? money : 0;
		this.myGasStation = (myGasStation != null) ? myGasStation : null;
		this.numberOfVehicles = (numberOfVehicles > 0) ? numberOfVehicles : 1;
		this.myVehicles = new Vehicle [this.numberOfVehicles];
	}
	
	void addVehicles(Vehicle vehicle) {
		if (vehicle != null && this.indexAddVehicles < this.numberOfVehicles) {
			this.myVehicles[this.indexAddVehicles] = vehicle;
		}
	}
	
	void buyVignetteForOneVehicle (int indexMyVehicles, char durationOfVignette, int day, int month, int year){
		myVehicles[indexMyVehicles].setVignette(myGasStation.sale(myVehicles[indexMyVehicles], durationOfVignette, day, month, year));
		this.money -= myVehicles[indexMyVehicles].getVignette().getPrice();
	}
	
	void buyVignetteForAllVehicle (char durationOfVignette, int day, int month, int year) {
		for (int index = 0; index < myVehicles.length; index++){
			if (myVehicles[index] != null &&  myVehicles[index].getVignette() == null) {
				myVehicles[index].setVignette(myGasStation.sale(myVehicles[index], durationOfVignette, day, month, year));
				this.money -= myVehicles[index].getVignette().getPrice();
			}
		}
	}
	
	void expiredVignettes (int day, int month, int year) {
		for (int index = 0; index < myVehicles.length; index++) {
			if (this.myVehicles[index].getVignette().getYear() >= year 
				&& this.myVehicles[index].getVignette().getMonth() >= month 
				&& this.myVehicles[index].getVignette().getDay() >= day){
			} else {
				System.out.println(this.name + ": " + this.myVehicles[index].getModel() + " " + this.myVehicles[index].getYearOfManufacture());
			}
		}
	}

}

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
		this.myVehicles = new Vehicle[this.numberOfVehicles];
	}

	void addVehicles(Vehicle vehicle) {
		if (vehicle != null && this.indexAddVehicles < this.numberOfVehicles) {
			this.myVehicles[this.indexAddVehicles++] = vehicle;
		}
	}

	void buyVignetteForOneVehicle(int indexMyVehicles, char durationOfVignette, int day, int month, int year) {
		if (this.myVehicles[indexMyVehicles] != null && this.myGasStation != null) {
			myVehicles[indexMyVehicles]
					.setVignette(myGasStation.sale(myVehicles[indexMyVehicles], durationOfVignette, day, month, year));
			if (myVehicles[indexMyVehicles].getVignette() != null) {
				this.money -= myVehicles[indexMyVehicles].getVignette().getPrice();
			}
		}
	}

	void buyVignetteForAllVehicle(char durationOfVignette, int day, int month, int year) {

		for (int index = 0; index < myVehicles.length; index++) {
			if (myVehicles[index] != null && myVehicles[index].getVignette() == null) {
				char duration = ' ';
				if (durationOfVignette == 'd' || durationOfVignette == 'm' || durationOfVignette == 'y') {
					duration = durationOfVignette;
				} else {
					int randomDuration = (int) (Math.random() * 3);
					if (randomDuration > 1) {
						duration = 'y';
					} else {
						duration = (randomDuration == 1) ? 'm' : 'd';
					}
				}
				myVehicles[index].setVignette(myGasStation.sale(myVehicles[index], duration, day, month, year));
				if (myVehicles[index].getVignette() != null) {
					this.money -= myVehicles[index].getVignette().getPrice();
				}
			}
		}
	}

	void expiredVignettes(int day, int month, int year) {
		for (int index = 0; index < myVehicles.length; index++) {
			if (this.myVehicles[index] != null && this.myVehicles[index].getVignette() != null) {
				if (this.myVehicles[index].getVignette().isExpired(day, month, year)){
					System.out.println(this.myVehicles[index].toString() + " expired! ");
				}
			}
		}
	}

	public void printInfo() {
		System.out.println("Driver - " + this.name + ", money " + this.money + " ");
		System.out.println("Vehicles: ");
		for (Vehicle vehicle : this.myVehicles) {
			if (vehicle != null) {
				System.out.println(vehicle.toString());
			}
		}
	}

	public Vehicle[] getMyVehicles() {
		return myVehicles;
	}

	public GasStation getMyGasStation() {
		return myGasStation;
	}

}

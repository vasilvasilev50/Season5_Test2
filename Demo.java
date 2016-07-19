package salesVignettes;

import salesVignettes.Bus;
import salesVignettes.Car;
import salesVignettes.Truck;
import salesVignettes.Vehicle;
import salesVignettes.GasStation;

public class Demo {

	private static final int NUMBER_OF_VEHICLES = 200;

	public static void main(String[] args) {

		GasStation g1 = new GasStation();
		GasStation g2 = new GasStation();

		Driver[] drivers = { new Driver("Driver1", 5000, g1, 10), new Driver("Driver2", 3000, g2, 10),
				new Driver("Driver3", 200, g1, 10), new Driver("Driver4", 800, g2, 10),
				new Driver("Driver5", 300, g1, 10), new Driver("Driver6", 7500, g2, 10),
				new Driver("Driver7", 2000, g1, 10), new Driver("Driver8", 8000, g2, 10),
				new Driver("Driver9", 2000, g1, 10), new Driver("Driver10", 8000, g2, 10),
				new Driver("Driver11", 20, g1, 10), new Driver("Driver12", 8000, g2, 10),
				new Driver("Driver13", 2000, g1, 10), new Driver("Driver14", 8000, g2, 10),
				new Driver("Driver15", 2000, g1, 10), new Driver("Driver16", 8000, g2, 10),
				new Driver("Driver17", 2000, g1, 10), new Driver("Driver18", 8000, g2, 10),
				new Driver("Driver19", 2000, g1, 10), new Driver("Driver20", 8000, g2, 10) };

		// for (Driver driver : drivers) {
		// driver.printInfo();
		// }

		Vehicle[] vehicles = new Vehicle[NUMBER_OF_VEHICLES];

		System.out.println();
		createVehiclesAndAddToArrayOfVehicles(vehicles);

		addVehiclesToDrivers(drivers, vehicles);

		buyVignettes(drivers, 19, 7, 2016);

		for (Driver driver : drivers) {
			System.out.println();
			driver.printInfo();
			System.out.println();
			driver.expiredVignettes(20, 8, 2018);
		}
//		g1.printInfo();
//		g2.printInfo();

	}

	private static void buyVignettes(Driver[] drivers, int day, int month, int year) {
		for (int index = 0; index < drivers.length; index++) {
			char durationOfVignette = ' ';
			if (index % 3 == 2) {
				for (int index2 = 0; index2 < drivers[index].getMyVehicles().length / 2; index2++) {
					int randomIndexVehicle = (int) (Math.random() * 10);
					if (drivers[index].getMyVehicles()[randomIndexVehicle] != null) {
						int randomDuration = (int) (Math.random() * 3);
						if (randomDuration > 1) {
							durationOfVignette = 'y';
						} else {
							durationOfVignette = (randomDuration == 1) ? 'm' : 'd';
						}
						if (drivers[index].getMyVehicles()[randomIndexVehicle].getVignette() == null) {
							drivers[index].buyVignetteForOneVehicle(randomIndexVehicle, durationOfVignette, day, month,
									year);
						} else {
							index2--;
						}
					}
				}
			} else {
				durationOfVignette = 'r';
				drivers[index].buyVignetteForAllVehicle(durationOfVignette, day, month, year);

			}

		}
	}

	private static void addVehiclesToDrivers(Driver[] drivers, Vehicle[] vehicles) {
		int indexOfDriver = 0;
		for (int index = 0; index < NUMBER_OF_VEHICLES; index++) {
			if (indexOfDriver < drivers.length) {
				drivers[indexOfDriver].addVehicles(vehicles[index]);
				if (index % 10 == 9) {
					// drivers[indexOfDriver].printInfo();
					indexOfDriver++;
				}
			}
		}
	}

	private static void createVehiclesAndAddToArrayOfVehicles(Vehicle[] vehicles) {
		String model = "";
		for (int index = 0; index < NUMBER_OF_VEHICLES; index++) {
			int randomModel = (int) (Math.random() * 4);
			switch (randomModel) {
			case 0:
				model = "Mercedes";
				break;
			case 1:
				model = "Ford";
				break;
			case 2:
				model = "Volvo";
				break;
			case 3:
				model = "Toyota";
				break;
			}
			int randomYear = ((int) (Math.random() * (Vehicle.THISYEAR - Vehicle.OLDESTYEAROFMANUFACTURE + 1)))
					+ Vehicle.OLDESTYEAROFMANUFACTURE;
			int random2TypeOfVehicle = (int) (Math.random() * 3);
			switch (random2TypeOfVehicle) {
			case 0:
				vehicles[index] = new Car(model, randomYear);
				break;
			case 1:
				vehicles[index] = new Bus(model, randomYear);
				break;
			case 2:
				vehicles[index] = new Truck(model, randomYear);
				break;
			}
			// System.out.println(vehicles[index].toString() + " ");
		}
	}

}

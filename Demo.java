package salesVignettes;

import salesVignettes.Bus;
import salesVignettes.Car;
import salesVignettes.Truck;
import salesVignettes.Vehicle;

public class Demo {

	private static final int NUMBER_OF_VEHICLES = 200;

	public static void main(String[] args) {
		
		GasStation g1 = new GasStation();
		System.out.println();
		GasStation g2 = new GasStation();
		
		Driver [] drivers = {new Driver("Marto", 5000, g1, 10), new Driver("Maripena", 300, g1, 10),
							new Driver("Draganka", 2000, g1, 10), new Driver("Bojo", 800, g1, 10)};
		
		Vehicle [] vehicles = new Vehicle[NUMBER_OF_VEHICLES];
		
		System.out.println();
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
				vehicles[index] = new Car (model, randomYear);
				break;
			case 1:
				vehicles[index] = new Bus (model, randomYear);
				break;
			case 2:
				vehicles[index] = new Truck (model, randomYear);
				break;
			}
			System.out.print(vehicles[index].toString() + " ");
		}
		
		drivers[0].buyVignetteForOneVehicle(0, 'd', 18, 07, 2016);
		

	}

}

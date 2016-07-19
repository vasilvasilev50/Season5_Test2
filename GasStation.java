package salesVignettes;

import java.util.Arrays;
import salesVignettes.Vignette;

public class GasStation {

	static int NUMBER_OF_VIGNETTES = 1000;
	private float dailyTurnover;
	private Vignette[] availableVignettes;

	GasStation() {
		availableVignettes = new Vignette[NUMBER_OF_VIGNETTES];
		for (int index = 0; index < availableVignettes.length; index++) {
			int randomTypeOfVignette = (int) (Math.random() * 3);
			int random2TypeOfVehicle = (int) (Math.random() * 3);
			switch (random2TypeOfVehicle) {
			case 1:
				createRandomTruckVignettes(index, randomTypeOfVignette);
				break;
			case 2:
				createRandomBusVignettes(index, randomTypeOfVignette);
				break;
			default:
				createRandomCarVignettes(index, randomTypeOfVignette);
				break;
			}
		}
		SortVignettes.quickSort(availableVignettes, 0, availableVignettes.length - 1);
		for (int index = 0; index < availableVignettes.length; index++) {
			System.out.print(
					availableVignettes[index].getColor() + " " + availableVignettes[index].getPrice() + " EUR. ");
		}
	}
	
	public Vignette sale(Vehicle vehicle, char duration, int day, int month, int year) {
		if (vehicle!= null) {
				for (int index = 0; index < availableVignettes.length; index++) {
					if (availableVignettes[index] != null && availableVignettes[index].getDuration() == duration  
						&& availableVignettes[index].toBeStuck(vehicle) == Vignette.TIME_TO_STUCK_CAR_VIGNETTE) {
						availableVignettes[index].setDay(day);
						availableVignettes[index].setMonth(month);
						availableVignettes[index].setYear(year);
						dailyTurnover += availableVignettes[index].getPrice();
						availableVignettes = SortVignettes.bubbleSort(availableVignettes);
						return availableVignettes[index];
				}
			}
		}
		return null;
	}

	private void createRandomCarVignettes(int index, int randomTypeOfVignette) {
		switch (randomTypeOfVignette) {
		case 1:
			availableVignettes[index] = new CarVignette('m');
			break;
		case 2:
			availableVignettes[index] = new CarVignette('y');
			break;
		default:
			availableVignettes[index] = new CarVignette('d');
			break;
		}
	}

	private void createRandomBusVignettes(int index, int randomTypeOfVignette) {
		switch (randomTypeOfVignette) {
		case 1:
			availableVignettes[index] = new BusVignette('m');
			break;
		case 2:
			availableVignettes[index] = new BusVignette('y');
			break;
		default:
			availableVignettes[index] = new BusVignette('d');
			break;
		}
	}

	private void createRandomTruckVignettes(int index, int randomTypeOfVignette) {
		switch (randomTypeOfVignette) {
		case 1:
			availableVignettes[index] = new TruckVignette('m');
			break;
		case 2:
			availableVignettes[index] = new TruckVignette('y');
			break;
		default:
			availableVignettes[index] = new TruckVignette('d');
			break;
		}
	}

}

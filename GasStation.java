package salesVignettes;

//import java.util.Arrays;
import salesVignettes.Vignette;
import salesVignettes.*;

public class GasStation {

	static int NUMBER_OF_VIGNETTES = 10000;
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
		printInfo();
	}

	public void printInfo() {
		System.out.println("Gas station daily turnover: " + this.dailyTurnover);
		for (int index = 0; index < availableVignettes.length; index++) {
			if (availableVignettes[index] != null) {
				System.out.print(availableVignettes[index].getColor() + " " + availableVignettes[index].getPrice() + " EUR. ");
			} else {
				System.out.print("null ");
			}
		}
		System.out.println();
	}
	
	public Vignette sale(Vehicle vehicle, char duration, int day, int month, int year) {
		if (vehicle!= null) {
			int timeToStuck = 0;
			if (vehicle instanceof Car) {
				timeToStuck = Vignette.TIME_TO_STUCK_CAR_VIGNETTE;
			}
			if (vehicle instanceof Truck) {
				timeToStuck = Vignette.TIME_TO_STUCK_TRUCK_VIGNETTE;
			}
			if (vehicle instanceof Bus) {
				timeToStuck = Vignette.TIME_TO_STUCK_BUS_VIGNETTE;
			}
				for (int index = 0; index < availableVignettes.length; index++) {
					if (availableVignettes[index] != null && availableVignettes[index].getDuration() == duration  
						&& availableVignettes[index].toBeStuck() == timeToStuck) {
						availableVignettes[index].setDay(day);
						availableVignettes[index].setMonth(month);
						availableVignettes[index].setYear(year);
						dailyTurnover += availableVignettes[index].getPrice();
						Vignette temp = availableVignettes[index];
						availableVignettes[index] = null;
						SortVignettes.bubbleSort(this.availableVignettes);
						return temp;
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

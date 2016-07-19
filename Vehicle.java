package salesVignettes;

import salesVignettes.Bus;
import salesVignettes.Car;
import salesVignettes.Truck;

public class Vehicle {

	static final int OLDESTYEAROFMANUFACTURE = 1950;
	static final int THISYEAR = 2016;
	private String model;
	private int yearOfManufacture;
	private Vignette vignette;

	public Vehicle(String model, int yearOfManufacture) {
		this.model = (model != null && model.length() > 0) ? model : "No model";
		this.yearOfManufacture = (yearOfManufacture > +OLDESTYEAROFMANUFACTURE && yearOfManufacture < +THISYEAR) ? yearOfManufacture : 0;
	}
	
	@Override
	public String toString() {
		if (this.vignette != null) {
			return this.model + " " + this.yearOfManufacture + " " + this.vignette.getColor() + " "
					+ this.vignette.getPrice();
		}
		return this.model + " " + this.yearOfManufacture + " " + "No vignette";
	}

	public void setVignette(Vignette vignette) {
		if (vignette != null) {
			this.vignette = vignette;
		}
	}

	public Vignette getVignette() {
		return vignette;
	}

	public String getModel() {
		return model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

}

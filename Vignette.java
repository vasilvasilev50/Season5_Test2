package salesVignettes;

public abstract class Vignette implements IVignette {
	
	static final int TIME_TO_STUCK_BUS_VIGNETTE = 20;
	static final int TIME_TO_STUCK_TRUCK_VIGNETTE = 10;
	static final int TIME_TO_STUCK_CAR_VIGNETTE = 5;
	static final int MONTHLY_APPRECIATION = 10;
	static final int YEARLI_APPRECIATION = 6;

	private int day;
	private int month;
	private int year;
	private String color;
	private char duration;

	public Vignette(char duration) {
		this.duration = (duration == 'd' || duration == 'm' || duration == 'y') ? duration : 'd';	
	}

	public int toBeStuck(Vehicle vehicle) {
		if (vehicle != null) {
			if (vehicle instanceof Car) {
				return TIME_TO_STUCK_CAR_VIGNETTE;
			}
			if (vehicle instanceof Truck) {
				return TIME_TO_STUCK_TRUCK_VIGNETTE;
			}
			if (vehicle instanceof Bus) {
				return TIME_TO_STUCK_BUS_VIGNETTE;
			}
		}
		return 0;
	}
	
	public char getDuration() {
		return duration;
	}
	
	protected void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = (day > 0 && day < 32) ? day : 0;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = (month > 0 && month < 13) ? month : 0;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = (year > 2015 && year < 2020) ? year : 0;
	}

}

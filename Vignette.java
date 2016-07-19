package salesVignettes;

public abstract class Vignette implements IVignette {
	
	static final int TIME_TO_STUCK_BUS_VIGNETTE = 20;
	static final int TIME_TO_STUCK_TRUCK_VIGNETTE = 10;
	static final int TIME_TO_STUCK_CAR_VIGNETTE = 5;
	static final int MONTHLY_APPRECIATION = 10;
	static final int YEARLI_APPRECIATION = 6;
	static final int DAILY_VIGNETTE_DURATION = 7;
	static final int MONTHLY_VIGNETTE_DURATION = 31;

	private int day;
	private int month;
	private int year;
	private String color;
	private char duration;

	public Vignette(char duration) {
		this.duration = (duration == 'd' || duration == 'm' || duration == 'y') ? duration : 'd';	
	}

	public int toBeStuck() {
		if (this != null) {
			if (this instanceof CarVignette) {
				return TIME_TO_STUCK_CAR_VIGNETTE;
			}
			if (this instanceof TruckVignette) {
				return TIME_TO_STUCK_TRUCK_VIGNETTE;
			}
			if (this instanceof BusVignette) {
				return TIME_TO_STUCK_BUS_VIGNETTE;
			}
		}
		return 0;
	}
	
	public boolean isExpired(int day, int month, int year) {
		if (this.duration == 'd'){
		return isExpiredDaily(day, month, year);
		}
		if (this.duration == 'm') {
			return isExpiredMonthly(day, month, year);
		}
		if (this.duration == 'y') {
			isExpiredYearly(day, month, year);
		}
		return false;
	}

	public boolean isExpiredYearly(int day, int month, int year) {
		if (this.year > year) {
			return false; 
		} else {
			if (this.year+1 == year){
				if (this.month > month || (this.month == month && this.day > day)){
					return false;
				}
			}
		}
		return true;
	}

	public boolean isExpiredMonthly(int day, int month, int year) {
		if (this.year == year && (this.month >= month || this.month+1 == month && this.day > day)) {
			return false;
		} else {
			if (this.year > year || (this.year+1 == year && this.month == 12 && month == 1 && this.day - day > 0)) {
				return false;
			}
		}
		return true;
	}

	public boolean isExpiredDaily(int day, int month, int year) {
		if (this.year == year) {
			if (this.month == month) {
				if (day - this.day <= DAILY_VIGNETTE_DURATION) {
					return false;
				}
			} else {
				if ((this.month+1 == month) && day + MONTHLY_VIGNETTE_DURATION - this.day <= DAILY_VIGNETTE_DURATION) {
					return false;
				}
			}
		} else {
			if (this.year > year || (this.year+1 == year && this.month == 12 && month == 1 && day + MONTHLY_VIGNETTE_DURATION - this.day <= DAILY_VIGNETTE_DURATION)){
				return false;
			}
		}
		return true;
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

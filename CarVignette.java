package salesVignettes;

public class CarVignette extends Vignette {

	private static final int DAILY_PRICE = 5;
	private static final int MONTHLY_PRICE = DAILY_PRICE * MONTHLY_APPRECIATION;
	private static final int YEARLY_PRICE = MONTHLY_PRICE * YEARLI_APPRECIATION;

	public CarVignette(char duration) {
		super(duration);
		super.setColor("yellow");
	}

	@Override
	public int getPrice() {
		if (super.getDuration() == 'd') {
			return CarVignette.DAILY_PRICE;
		}
		if (super.getDuration() == 'm') {
			return CarVignette.MONTHLY_PRICE;
		}
		if (super.getDuration() == 'y') {
			return CarVignette.YEARLY_PRICE;
		}
		return 0;

	}

	

}

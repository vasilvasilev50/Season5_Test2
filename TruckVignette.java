package salesVignettes;

public class TruckVignette extends Vignette {

	private static final int DAILY_PRICE = 7;
	private static final int MONTHLY_PRICE = DAILY_PRICE*MONTHLY_APPRECIATION;
	private static final int YEARLY_PRICE = MONTHLY_PRICE*YEARLI_APPRECIATION;

	public TruckVignette(char duration) {
		super(duration);
		super.setColor("green");
	}

	@Override
	public int getPrice() {
		if (super.getDuration() == 'd') {
			return TruckVignette.DAILY_PRICE;
		}
		if (super.getDuration() == 'm') {
			return TruckVignette.MONTHLY_PRICE;
		}
		if (super.getDuration() == 'y') {
			return TruckVignette.YEARLY_PRICE;
		}
		return 0;
		
	}

}

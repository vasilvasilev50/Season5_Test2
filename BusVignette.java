package salesVignettes;

public class BusVignette extends Vignette {

	private static final int DAILY_PRICE = 9;
	private static final int MONTHLY_PRICE = DAILY_PRICE*MONTHLY_APPRECIATION;
	private static final int YEARLY_PRICE = MONTHLY_PRICE*YEARLI_APPRECIATION;

	public BusVignette(char duration) {
		super(duration);
		super.setColor("red");
	}

	@Override
	public int getPrice() {
		if (super.getDuration() == 'd') {
			return BusVignette.DAILY_PRICE;
		}
		if (super.getDuration() == 'm') {
			return BusVignette.MONTHLY_PRICE;
		}
		if (super.getDuration() == 'y') {
			return BusVignette.YEARLY_PRICE;
		}
		return 0;
		
	}

}

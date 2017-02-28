package Pizza;

public final class PizzaBacon implements Pizza {

	private int priceBacon = 33;

	public void setPriceBacon(int priceBacon) {
		this.priceBacon = priceBacon;
	}

	public int getPriceBacon() {
		return priceBacon;
	}

	@Override
	public void cut() {
		System.out.println("Pizza with bacon should be cut triangles");
	}

	@Override
	public int price() {
		return billetPrice + priceBacon;
	}

	@Override
	public String toString() {
		return "PizzaBacon [priceBacon=" + priceBacon + "]";
	}

}

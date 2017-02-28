package Pizza;


public class PizzaMushrooms implements Pizza {

	private int priceMushrooms;

	public PizzaMushrooms(int priceMushrooms) {
		this.priceMushrooms = priceMushrooms;
	}

	public PizzaMushrooms() {
	}

	public int getPriceMushrooms() {
		return priceMushrooms;
	}

	public void setPriceMushrooms(int priceMushrooms) {
		this.priceMushrooms = priceMushrooms;
	}

	@Override
	public void cut() {
		System.out.println("Pizza with mushrooms should be cut squares");
	}

	@Override
	public int price() {
		return billetPrice + priceMushrooms;
	}

	@Override
	public String toString() {
		return "PizzaMushrooms [priceMushrooms=" + priceMushrooms + "]";
	}

	public static class Builder {

		private final PizzaMushrooms pizzaMushrooms = new PizzaMushrooms();

		public Builder priceMushrooms(int priceMushrooms) {
			pizzaMushrooms.priceMushrooms = priceMushrooms;
			return this;
		}

		public PizzaMushrooms build() {
			return pizzaMushrooms;
		}
	}

}

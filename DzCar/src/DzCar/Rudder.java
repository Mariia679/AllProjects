package DzCar;

public class Rudder {

	private double diametr;

	private boolean button;

	public Rudder(double diametr, boolean button) {
		this.diametr = diametr;
		this.button = button;
	}

	public boolean isButton() {
		return button;
	}

	public void setButton(boolean button) {
		this.button = button;
	}

	public void increaseRudder() {
		diametr += 10;
	}

	public double getDiametr() {
		return diametr;
	}

	public void setDiametr(double diametr) {
		this.diametr = diametr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (button ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(diametr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rudder other = (Rudder) obj;
		if (button != other.button)
			return false;
		if (Double.doubleToLongBits(diametr) != Double
				.doubleToLongBits(other.diametr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rudder [diametr=" + diametr + ", button=" + button + "]";
	}

}

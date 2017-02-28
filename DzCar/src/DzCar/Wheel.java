package DzCar;

public class Wheel {

	private double diametrWheel;

	public Tire tire;

	public Wheel(double diametrWheel, Tire tire) {
		this.diametrWheel = diametrWheel;
		this.tire = tire;
	}

	public void increaseDiametrWheel(int increase) {
		diametrWheel *= increase;
	}

	public double getDiametrWheel() {
		return diametrWheel;
	}

	public void setDiametrWheel(double diametrWheel) {
		this.diametrWheel = diametrWheel;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(diametrWheel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tire == null) ? 0 : tire.hashCode());
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
		Wheel other = (Wheel) obj;
		if (Double.doubleToLongBits(diametrWheel) != Double
				.doubleToLongBits(other.diametrWheel))
			return false;
		if (tire != other.tire)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wheel [diametrWheel=" + diametrWheel + ", tire=" + tire + "]";
	}

}
